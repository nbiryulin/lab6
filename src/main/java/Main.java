import java.sql.*;
import org.hibernate.Session;
import util.HibernateUtil;

public class Main {


  public static void main(String[] args) {
    String url = "jdbc:postgresql://localhost:5432/music_shop";
    String username = "postgres";
    String password = "12345";
    try {
      Connection connection = DriverManager.getConnection(url, username, password);
      Statement statement = connection.createStatement();

      Session s = HibernateUtil.getSessionFactory().openSession();
      s.close();
//      statement.executeUpdate("insert into artist(id, name) values ('77','artistnew')");
//      ResultSet resultSet = statement.executeQuery("select * from artist");
//      while (resultSet.next()) {
//        System.out.println(resultSet.getString(1));
//        System.out.println(resultSet.getString(2));
//      }
//      statement.executeUpdate("update artist set name='artistold' where name ='artistnew'");
      statement.executeUpdate("delete from artist where name ='artistold'");

      //resultSet.close();
      statement.close();
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

    }
  }

}
