package pl.edu.agh.mwo.hibernate.repository;
import org.hibernate.Session;


public interface HibernateRepository {

    <T> T findById(long id);

    default <T> void save(T t) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(t);

        session.getTransaction().commit();
        session.close();

    }

    default <T> void remove(T t) {

        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction();

        session.remove(t);

        session.getTransaction().commit();
        session.close();

    }


}
