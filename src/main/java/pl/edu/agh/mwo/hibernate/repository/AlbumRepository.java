package pl.edu.agh.mwo.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.edu.agh.mwo.hibernate.entity.Album;
import pl.edu.agh.mwo.hibernate.entity.User;

public class AlbumRepository implements HibernateRepository{
    @Override
    public Album findById(long id){

        final Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Album> query = session.createQuery("from Album where id = :id", Album.class);
        query.setParameter("id", id);

        Album album = query.uniqueResult();

        session.close();

        return album;

    }

    @Override
    public void deleteById(long id){
        final Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Album> query = session.createQuery("from Album where id = :id", Album.class);
        query.setParameter("id", id);

        Album album = query.uniqueResult();

        session.beginTransaction();

        session.delete(album);

        session.getTransaction().commit();

        session.close();


    }

}
