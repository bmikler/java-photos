package pl.edu.agh.mwo.hibernate.service;

import pl.edu.agh.mwo.hibernate.entity.Album;
import pl.edu.agh.mwo.hibernate.entity.Photo;
import pl.edu.agh.mwo.hibernate.entity.User;
import pl.edu.agh.mwo.hibernate.repository.AlbumRepository;
import pl.edu.agh.mwo.hibernate.repository.PhotoRepository;
import pl.edu.agh.mwo.hibernate.repository.UserRepository;

public class PhotosService {

    private final AlbumRepository albumRepository;
    private final PhotoRepository photoRepository;
    private final UserRepository userRepository;

    public PhotosService(AlbumRepository albumRepository, PhotoRepository photoRepository, UserRepository userRepository) {
        this.albumRepository = albumRepository;
        this.photoRepository = photoRepository;
        this.userRepository = userRepository;
    }

    public Album findAlbumById(long id) {
        return albumRepository.findById(id);
    }

    public Photo findPhotoById(long id) {
        return photoRepository.findById(id);
    }

    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    public void createUser(User user) {

        userRepository.save(user);

    }

    public void removeUser(long userId) {

        User user = userRepository.findById(userId);
        userRepository.remove(user);

    }

    public void createAlbum(long userId, Album album) {

        User user = userRepository.findById(userId);
        user.addAlbum(album);
        userRepository.update(user);

    }

    public void removeAlbum(long albumId) {

        Album album = albumRepository.findById(albumId);
        albumRepository.remove(album);


    }

    public void addPicture(long albumId, Photo photo) {

        Album album = albumRepository.findById(albumId);
        album.addPhoto(photo);
        albumRepository.update(album);

    }

    public void removePicture(long photoId) {

        Photo photo = photoRepository.findById(photoId);
        photoRepository.remove(photo);

    }

    public void like(long userId, long photoId) {

        Photo photo = photoRepository.findById(photoId);
        User user = userRepository.findById(userId);

        photo.addLike(user);
        photoRepository.update(photo);


    }

    public void unLike(long userId, long photoId) {
        Photo photo = photoRepository.findById(photoId);
        User user = userRepository.findById(userId);

        photo.removeLike(user);
        photoRepository.update(photo);
    }

}
