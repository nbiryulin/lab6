package dao;


import java.util.List;
import model.Album;
import model.Artist;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class AlbumDAO {

  public void save(Album artist){
    Session session= HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(artist);
    session.getTransaction().commit();
    session.close();
  }
  public List<Album> getAll(){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<Album> list= session.createQuery("from Album").list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  public void update(Album artist){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(artist);
    session.getTransaction().commit();
    session.close();
  }
  public Album getById(int id){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Query query= session.createQuery("from Album where id=:id");
    query.setInteger("id",id);
    Album artist= (Album) query.uniqueResult();
    session.getTransaction().commit();
    session.close();
    return artist;
  }
  public void delete(int id){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Query query=session.createQuery("from Album where id=:id");
    query.setInteger("id",id);
    Album artist= (Album) query.uniqueResult();
    session.delete(artist);
    session.getTransaction().commit();
    session.close();
  }

}
