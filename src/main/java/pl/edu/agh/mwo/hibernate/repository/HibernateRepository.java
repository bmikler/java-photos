package pl.edu.agh.mwo.hibernate.repository;
import org.hibernate.Session;


public interface HibernateRepository {

    <T> T findById(long id);
    
    void deleteById(long id);

    default <T> void save(T t) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(t);

        session.getTransaction().commit();
        session.close();

    }

    default <T> void update(T t) {

        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.merge(t);

        session.getTransaction().commit();
        session.close();

    }
    

}
