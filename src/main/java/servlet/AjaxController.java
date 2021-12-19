package servlet;

import dao.ArtistDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Artist;

@WebServlet("/AjaxController")
public class AjaxController extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArtistDAO artistDAO = new ArtistDAO();

    response.setContentType("text/plain");
//    String fullname = request.getParameter("fullname");
//    artistDAO.findByName(fullname);
//    fullname = fullname == null ? "" : fullname;
    List<String> artists = artistDAO.findByName();
    PrintWriter out = response.getWriter();
    out.print(artists);
  }

}
