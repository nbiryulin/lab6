package servlet;

import dao.ArtistDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Artist;

public class SaveServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ArtistDAO artistDAO=new ArtistDAO();
    ////////////////////////////////////////
    //INDEX.JSP
    ////////////////////////////////////////
    if(request.getParameter("add")!=null){//при нажатии на кнопку add
      Artist artist=new Artist();//создаём экземпляр класса модели базы данных
      artist.setId(Integer.parseInt(request.getParameter("id")));//задаём ему id взятый из поля c именем id
      artist.setName(request.getParameter("name"));//аналогично с прошлой строкой
      artistDAO.save(artist);//сохраняем в базу данных полученный объект
      request.setAttribute("list",artistDAO.getAll());//создаём аттрибут который взял в себя всё что есть в базе данных
      RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
      requestDispatcher.forward(request,response);
    }
    if(request.getParameter("showAll")!=null){//при нажатии на кнопку showALL
      request.setAttribute("list",artistDAO.getAll());//создаём аттрибут который взял в себя всё что есть в базе данных
      RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
      requestDispatcher.forward(request,response);
    }
    ///////////////////////////////////////////////////
    //LIST.JSP
    ///////////////////////////////////////////////////
    String action=request.getParameter("action");//создаём action который будет реагировать на те или иные действия
    if(action.equalsIgnoreCase("update")){//если action отреагировал на update
      request.setAttribute("artist",artistDAO.getById(Integer.parseInt(request.getParameter("id"))));//создаём атрибут который по id возвращает определённого HeroesEntity
      RequestDispatcher requestDispatcher=request.getRequestDispatcher("update.jsp");////перебрасываемся на update.jsp
      requestDispatcher.forward(request,response);
    }
    if(action.equalsIgnoreCase("delete")){//если action отреагировал на update
      artistDAO.delete(Integer.parseInt(request.getParameter("id")));//удаляем по id
      request.setAttribute("list",artistDAO.getAll());//создаём аттрибут который взял в себя всё что есть в базе данных
      RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
      requestDispatcher.forward(request,response);
    }
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ArtistDAO artistDAO = new ArtistDAO();
//////////////////////////////////
// UPDATE.JSP
//////////////////////////////////
    if (request.getParameter("update") != null) {//при нажатии на кнопку update
      Artist artist = new Artist();//создаём экземпляр класса
      artist.setId(Integer.parseInt(request.getParameter("id")));//задаём id из поля idhero
      artist.setName(request.getParameter("name"));//задаём name из поля name
      artistDAO.update(artist);//апдейтим
      request.setAttribute("list", artistDAO.getAll());//создаём аттрибут который взял в себя всё что есть в базе данных
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
      requestDispatcher.forward(request, response);
    }
  }

}
