package servlet;

import dao.AlbumDAO;
import dao.ArtistDAO;
import dao.TrackDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Album;
import model.Artist;
import model.Track;

public class SaveAllServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ArtistDAO artistDAO = new ArtistDAO();
    TrackDAO trackDAO = new TrackDAO();
    AlbumDAO albumDAO = new AlbumDAO();
    //INDEX.JSP
    String action = request.getParameter("action");
    if (request.getParameter("showAll") != null) {
      request.setAttribute("list", artistDAO.getAll());
      request.setAttribute("albums", albumDAO.getAll());
      request.setAttribute("track", trackDAO.getAll());
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
      requestDispatcher.forward(request, response);
    }
    //LIST.JSP
    else if (action != null && action.equalsIgnoreCase("update")) {
      RequestDispatcher requestDispatcher = null;

      String type = request.getParameter("type");
      switch (type) {
        case "art":
          request.setAttribute("artist",
              artistDAO.getById(Integer.parseInt(request.getParameter("id"))));
          requestDispatcher = request.getRequestDispatcher("update.jsp");
          break;
        case "alb":
          request.setAttribute("album",
              albumDAO.getById(Integer.parseInt(request.getParameter("id"))));
          requestDispatcher = request.getRequestDispatcher("updateAlb.jsp");
          break;
        case "tr":
          request.setAttribute("track",
              trackDAO.getById(Integer.parseInt(request.getParameter("id"))));
          requestDispatcher = request.getRequestDispatcher("updateTrack.jsp");
          break;
      }
      requestDispatcher.forward(request, response);
    } else if (action != null && action.equalsIgnoreCase("delete")) {
      String type = request.getParameter("type");

      switch (type) {
        case "art":
          artistDAO.delete(Integer.parseInt(request.getParameter("id")));
          break;
        case "alb":
          albumDAO.delete(Integer.parseInt(request.getParameter("id")));
          break;
        case "tr":
          trackDAO.delete(Integer.parseInt(request.getParameter("id")));
          break;
      }

      request.setAttribute("albums", albumDAO.getAll());
      request.setAttribute("track", trackDAO.getAll());
      request.setAttribute("list", artistDAO.getAll());
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
      requestDispatcher.forward(request, response);
    } else if (request.getParameter("add") != null) {
      String value = request.getParameter("add");

      switch (value) {
        case "addArtist": {
          Artist artist = new Artist();
          artist.setName(request.getParameter("name"));
          artistDAO.save(artist);
          break;
        }
        case "addAlbum": {
          Album album = new Album();
          Artist artist = artistDAO.getById(Integer.valueOf(request.getParameter("artists_id")));
          album.setName(request.getParameter("album_name"));
          album.setType(request.getParameter("type"));
          album.setArtist(artist);
          albumDAO.save(album);
          break;
        }
        case "addTrack": {
          Track track = new Track();
          Artist artist = artistDAO.getById(Integer.valueOf(request.getParameter("artist_id")));
          Album album = albumDAO.getById(Integer.valueOf(request.getParameter("album_id")));
          track.setName(request.getParameter("track_name"));
          track.setTime(Integer.parseInt(request.getParameter("time")));
          track.setArtist(artist);
          track.setAlbum(album);
          trackDAO.save(track);
          break;
        }
      }

      request.setAttribute("albums", albumDAO.getAll());
      request.setAttribute("track", trackDAO.getAll());
      request.setAttribute("list", artistDAO.getAll());
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
      requestDispatcher.forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ArtistDAO artistDAO = new ArtistDAO();
    TrackDAO trackDAO = new TrackDAO();
    AlbumDAO albumDAO = new AlbumDAO();

    if (request.getParameter("update") != null) {

      String type = request.getParameter("types");

      switch (type) {
        case "art": {
          Artist artist = artistDAO.getById(Integer.parseInt(request.getParameter("id")));
          artist.setName(request.getParameter("name"));
          artistDAO.update(artist);
          break;
        }
        case "alb": {
          Album artist = albumDAO.getById(Integer.parseInt(request.getParameter("id")));
          artist.setName(request.getParameter("name"));
          artist.setType(request.getParameter("type"));
          albumDAO.update(artist);
          break;
        }

        case "tr": {
          Track artist = trackDAO.getById(Integer.parseInt(request.getParameter("id")));
          artist.setName(request.getParameter("name"));
          artist.setTime(Integer.parseInt(request.getParameter("time")));
          trackDAO.update(artist);
          break;
        }
      }

      request.setAttribute("albums", albumDAO.getAll());
      request.setAttribute("track", trackDAO.getAll());
      request.setAttribute("list", artistDAO.getAll());
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
      requestDispatcher.forward(request, response);
    }
  }

}
