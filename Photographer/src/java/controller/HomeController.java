/*
 * Copyright(C) 2005,  FPT University.
 * J3.L.P0017:
 * Photograph
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-06-20     1.0              TungCTHE141487      First Implement
 */
package controller;

import dao.IGalleryDAO;
import dao.IIntroductionDAO;
import dao.IShareDAO;
import dao.impl.GalleryDAO;
import dao.impl.IntroductionDAO;
import dao.impl.ShareDAO;
import entity.Gallery;
import entity.Introduction;
import entity.Share;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class uses function in <code>GalleryDAO</code> class to get list image of
 * Gallery object, paginate the Gallery by PageSize and indexPage.<br>
 * - Uses function in <code>ShareDAO</code> class to get list Share object.<br>
 * - Uses function in <code>IntroductionDAO</code> class to get information of
 * Introduction object.<br>
 * - Then forward to <code>Home.jsp</code>
 *
 * @author TungCTHE141487
 */
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods, uses function in <code>GalleryDAO</code> class to get list image
     * of Gallery object, paginate the Gallery by PageSize and indexPage<br>
     * The result contains a <code>entity.Gallery</code> objects with id, name
     * description,image.<br>
     * - Uses function in <code>ShareDAO</code> class to get list Share
     * object<br>
     * The result contains a <code>entity.Share</code> objects with icon,
     * socialNetwork, url<br>
     * - Uses function in <code>IntroductionDAO</code> class to get information
     * of Introduction object<br>
     * The result contains a <code>entity.Introduction</code> objects with
     * image, entry, aboutMe.<br>
     * - Then forward to <code>Home.jsp</code>
     *
     * @param request stores attribute: share, galleries, info, maxPage,
     * pageIndex and send to JSP.<br>
     * It is the <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response is used to store the attribute and sends a response to
     * client's browser.<br>
     * It is the <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs, it is the
     * <code> javax.servlet.ServletException</code> object
     * @throws IOException if an I/O error occurs, it is the
     * <code>java.io.IOException</code> object
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {

            IGalleryDAO galleryDAO = new GalleryDAO();
            //Get Share
            IShareDAO shareDAO = new ShareDAO();
            List<Share> listshare = shareDAO.getShare();
            // check the content of Share object is empty
            if (listshare.isEmpty()) {
                request.setAttribute("error", "Data share error");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                request.setAttribute("share", listshare);
            }

            List<Gallery> listGalleries = galleryDAO.getTopGallery(3);
            // check the list of Gallery object is empty
            if (listGalleries.isEmpty()) {
                request.setAttribute("error", "Data  Fail !!!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                request.setAttribute("galleries", listGalleries);
            }

            //Get index page
            String page = request.getParameter("page");
            int indexPage = 1;
            // check number of page is null 
            if (page == null) {
                page = "1";
            }
            // check indexpage is number or not
            try {
                indexPage = Integer.parseInt(page);
            } catch (NumberFormatException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            //Number of items in a page
            int pageSize = 3;

            //All number of items
            int rowCount = galleryDAO.numberOfResult();
            //Maximum of page 
            int maxPage = rowCount / pageSize + (rowCount % pageSize > 0 ? 1 : 0);
            // check index of page with the maximum of page
            if (indexPage <= maxPage && indexPage > 0) {
                listGalleries = galleryDAO.pagging(indexPage, pageSize);
                request.setAttribute("galleries", listGalleries);
                request.setAttribute("maxPage", maxPage);
                request.setAttribute("pageIndex", indexPage);
            } else {
                request.setAttribute("error", "Data not found! Because index page is out of rage");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

            // Get Introduction information
            IIntroductionDAO introductionDAO = new IntroductionDAO();
            Introduction introduction = introductionDAO.getIntroduction();
            // check intro of Introduction object is null
            if (introduction == null) {
                request.setAttribute("error", "Data Intro error!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                //Set image for intro element
                request.setAttribute("intro", introduction);
            }

            //Set hight light when we click or stay home page
            request.setAttribute("clickedHome", true);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Calls the <code>processRequest</code> method
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Calls the <code>processRequest</code> method
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
