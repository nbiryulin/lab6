package dao;
import java.util.List;
import model.Album;
import model.Artist;
import model.Track;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class TrackDAO {

  public void save(Track artist){
    Session session= HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(artist);
    session.getTransaction().commit();
    session.close();
  }
  public List<Track> getAll(){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    List<Track> list= session.createQuery("from Track ").list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  public void update(Track artist){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(artist);
    session.getTransaction().commit();
    session.close();
  }
  public Track getById(int id){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Query query= session.createQuery("from Track where id=:id");
    query.setInteger("id",id);
    Track track= (Track) query.uniqueResult();
    session.getTransaction().commit();
    session.close();
    return track;
  }
  public void delete(int id){
    Session session=HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Query query=session.createQuery("from Track where id=:id");
    query.setInteger("id",id);
    Track track= (Track) query.uniqueResult();
    session.delete(track);
    session.getTransaction().commit();
    session.close();
  }

  public List<Track> findByArtist(String name) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    Query query = session.createQuery("from Track where artist.name = :name");
    query.setParameter("name", name);
    List<Track> artist = query.list();
    session.getTransaction().commit();
    session.close();
    return artist;
  }

}
