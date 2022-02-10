package pl.edu.agh.mwo.hibernate;

import org.hibernate.Session;
import pl.edu.agh.mwo.hibernate.entity.User;
import pl.edu.agh.mwo.hibernate.repository.HibernateRepository;
import pl.edu.agh.mwo.hibernate.repository.HibernateUtil;
import pl.edu.agh.mwo.hibernate.repository.UserRepository;

import java.time.LocalDateTime;

public class Main {

	Session session;

	public static void main(String[] args) {
		Main main = new Main();

		UserRepository repository = new UserRepository();

		// tu wstaw kod aplikacji
		User user = new User("tester2", LocalDateTime.now());
		repository.save(user);

		System.out.println(repository.findById(1L));

		main.close();
	}

	public Main() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void close() {
		session.close();
		HibernateUtil.shutdown();
	}
}
