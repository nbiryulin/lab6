package dao;

import java.util.List;
import model.Artist;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class ArtistDAO {

  public void save(Artist artist){
    Session session= HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(artist);
    session.getTransaction().commit();
    session.close();
  }
  public List<Artist> getAll(){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<Artist> list= session.createQuery("from Artist ").list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  public void update(Artist artist){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(artist);
    session.getTransaction().commit();
    session.close();
  }
  public Artist getById(int id){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Query query= session.createQuery("from Artist where id=:id");
    query.setInteger("id",id);
    Artist artist= (Artist) query.uniqueResult();
    session.getTransaction().commit();
    session.close();
    return artist;
  }
  public void delete(int id){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Query query=session.createQuery("from Artist where id=:id");
    query.setInteger("id",id);
    Artist artist= (Artist) query.uniqueResult();
    session.delete(artist);
    session.getTransaction().commit();
    session.close();
  }

}
