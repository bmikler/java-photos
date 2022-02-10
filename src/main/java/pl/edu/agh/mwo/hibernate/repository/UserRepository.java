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

        return query.uniqueResult();

    }

}
