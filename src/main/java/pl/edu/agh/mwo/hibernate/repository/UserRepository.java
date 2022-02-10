package pl.edu.agh.mwo.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.edu.agh.mwo.hibernate.entity.User;

public class UserRepository implements HibernateRepository{

    @Override
    public User findById(long id){

        final Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("from User where id = :id", User.class);
        query.setParameter("id", id);

        User user = query.uniqueResult();

        session.close();

        return user;

    }

    @Override
    public void deleteById(long id){
        final Session session = HibernateUtil.getSessionFactory().openSession();

        Query<User> query = session.createQuery("from User where id = :id", User.class);
        query.setParameter("id", id);

        User user = query.uniqueResult();

        session.beginTransaction();

        session.delete(user);

        session.getTransaction().commit();

        session.close();


    }

}
