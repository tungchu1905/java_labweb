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
import dao.IInformationDAO;
import dao.IShareDAO;
import dao.impl.GalleryDAO;
import dao.impl.InformationDAO;
import dao.impl.ShareDAO;
import entity.Gallery;
import entity.Information;
import entity.Share;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class uses function in <code>InformationDAO</code> class to get content of
 * Information object.<br>
 * - Uses function in <code>ShareDAO</code> class to get list Share object.<br>
 * - Uses function in <code>GalleryDAO</code> class to get list of Gallery
 * object.<br>
 * - Then forward to <code>contact.jsp</code>
 *
 * @author TungCTHE141487
 */
@WebServlet(name = "ContactController", urlPatterns = {"/ContactController"})
public class ContactController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods, uses function in <code>InformationDAO</code> class to get
     * content of Information object.<br>
     * The result contains <code>entity.Infortmation</code> objects with
     * address, city, country, tel, email and image.<br>
     * - Uses function in <code>GalleryDAO</code> class to get list Gallery
     * object.<br>
     * The result contains a <code>entity.Gallery</code> objects with id, name
     * description,image.<br>
     * - Uses function in <code>ShareDAO</code> class to get list Share
     * object<br>
     * The result contains a <code>entity.Share</code> objects with icon,
     * socialNetwork, url.<br>
     * - Then forward to <code>contact.jsp</code>
     *
     * @param request stores attribute: share, galleries, info and send to
     * JSP.<br>
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
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30*60);
        try {
            IGalleryDAO galleryDAO = new GalleryDAO();
            //Get Share information 
            IShareDAO shareDAO = new ShareDAO();
            List<Share> listShare = shareDAO.getShare();
            // check list share of ShareDAO object
            if (listShare.isEmpty()) {
                request.setAttribute("error", "Data share error");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                request.setAttribute("share", listShare);
            }

            List<Gallery> listGalleries = galleryDAO.getTopGallery(3);
            // Check list of Gallery object
            if (listGalleries.isEmpty()) {
                request.setAttribute("error", "Data Fail !!!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                request.setAttribute("galleries", listGalleries);
            }
            // Get Contact
            IInformationDAO informationDAO = new InformationDAO();
            Information content = informationDAO.getInformation();

            request.setAttribute("info", content);
            request.setAttribute("clickedContact", true);
            request.getRequestDispatcher("contact.jsp").forward(request, response);
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
