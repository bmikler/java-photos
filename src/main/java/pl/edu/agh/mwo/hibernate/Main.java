package pl.edu.agh.mwo.hibernate;

import org.hibernate.Session;
import pl.edu.agh.mwo.hibernate.entity.Album;
import pl.edu.agh.mwo.hibernate.entity.Photo;
import pl.edu.agh.mwo.hibernate.entity.User;
import pl.edu.agh.mwo.hibernate.repository.*;
import pl.edu.agh.mwo.hibernate.service.PhotosService;

import java.time.LocalDateTime;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();

		PhotosService photosService = new PhotosService(new AlbumRepository(),
				new PhotoRepository(), new UserRepository());

		Photo photo = new Photo("testPhoto", LocalDateTime.now());
		Album album = new Album("testAblum", "testDescription");
		album.addPhoto(photo);

		User user = new User("tester", LocalDateTime.now());
		user.addAlbum(album);

		photosService.createUser(user);

		User watcher = new User("watcher", LocalDateTime.now());
		photosService.createUser(watcher);

		photosService.like(2L,1);

		photosService.addFriend(1L,2L);

		System.out.println("2");
		photosService.findUserById(2L).getFriends().forEach(System.out::println);
		System.out.println("1");
		photosService.findUserById(1L).getFriends().forEach(System.out::println);

		photosService.removeUser(2L);

		// tu wstaw kod aplikacji


		main.close();
	}

	public void close() {
		HibernateUtil.shutdown();
	}
}
