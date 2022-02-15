package pl.edu.agh.mwo.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.edu.agh.mwo.hibernate.entity.Photo;

public class PhotoRepository implements HibernateRepository{

    @Override
    public Photo findById(long id){

        final Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Photo> query = session.createQuery("from Photo where id = :id", Photo.class);
        query.setParameter("id", id);

        Photo photo = query.uniqueResult();

        session.close();

        return photo;

    }

    @Override
    public void deleteById(long id){
        final Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Photo> query = session.createQuery("from Photo where id = :id", Photo.class);
        query.setParameter("id", id);

        Photo photo = query.uniqueResult();

        session.beginTransaction();

        session.delete(photo);

        session.getTransaction().commit();

        session.close();


    }

}
