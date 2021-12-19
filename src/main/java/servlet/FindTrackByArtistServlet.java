package servlet;


import dao.AlbumDAO;
import dao.ArtistDAO;
import dao.TrackDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Album;

public class FindTrackByArtistServlet extends HttpServlet {

  protected void doGet(
      HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    AlbumDAO albumDAO = new AlbumDAO();
    ArtistDAO artistDAO = new ArtistDAO();
    TrackDAO trackDAO = new TrackDAO();

    String name = request.getParameter("name");
    request.setAttribute("result",trackDAO.findByArtist(name) );
    request.setAttribute("albums", albumDAO.getAll());
    request.setAttribute("track", trackDAO.getAll());
    request.setAttribute("list", artistDAO.getAll());
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
    requestDispatcher.forward(request, response);
  }


}