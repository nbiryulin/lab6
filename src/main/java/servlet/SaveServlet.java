//package servlet;
//
//import dao.AlbumDAO;
//import dao.ArtistDAO;
//import dao.TrackDAO;
//import java.io.IOException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import model.Album;
//import model.Artist;
//
//public class SaveServlet extends HttpServlet {
//  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    ArtistDAO artistDAO=new ArtistDAO();
//    AlbumDAO albumDAO = new AlbumDAO();
//    TrackDAO trackDAO = new TrackDAO();
//    //INDEX.JSP
//    if(request.getParameter("add")!=null){
//
//      Artist artist=new Artist();
//      artist.setName(request.getParameter("name"));
//      artistDAO.save(artist);
//
//      Album album = new Album();
//      album.setArtist(artist);
//      album.setName(request.getParameter("album_name"));
//      album.setType(request.getParameter("type"));
//      albumDAO.save(album);
//
//      request.setAttribute("list", artistDAO.getAll());
//      request.setAttribute("albums", albumDAO.getAll());
//      request.setAttribute("track", trackDAO.getAll());
//      RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
//      requestDispatcher.forward(request,response);
//    }
//    if(request.getParameter("showAll")!=null){
//      request.setAttribute("list", artistDAO.getAll());
//      request.setAttribute("albums", albumDAO.getAll());
//      request.setAttribute("track", trackDAO.getAll());
//      RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
//      requestDispatcher.forward(request,response);
//    }
//
//    //LIST.JSP
//
//    String action=request.getParameter("action");
//    if(action.equalsIgnoreCase("update")){
//      request.setAttribute("artist",artistDAO.getById(Integer.parseInt(request.getParameter("id"))));
//      RequestDispatcher requestDispatcher=request.getRequestDispatcher("update.jsp");
//      requestDispatcher.forward(request,response);
//    }
//    if(action.equalsIgnoreCase("delete")){
//      artistDAO.delete(Integer.parseInt(request.getParameter("id")));
//      request.setAttribute("list",artistDAO.getAll());
//      RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
//      requestDispatcher.forward(request,response);
//    }
//  }
//  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    ArtistDAO artistDAO = new ArtistDAO();
//// UPDATE.JSP
//    if (request.getParameter("update") != null) {
//      Artist artist = new Artist();
//      artist.setName(request.getParameter("name"));
//      artistDAO.update(artist);
//      request.setAttribute("list", artistDAO.getAll());
//      RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
//      requestDispatcher.forward(request, response);
//    }
//  }
//
//}
