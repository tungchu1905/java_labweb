/*
 * Copyright(C) 2005,  FPT University.
 * J3.L.P0017:
 * Photograph
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-05-25     1.0              TungCTHE141487      First Implement
 */
package controller;

import dao.IGalleryDAO;
import dao.IImageGalleryDAO;
import dao.IShareDAO;
import dao.impl.GalleryDAO;
import dao.impl.ImageGalleryDAO;
import dao.impl.ShareDAO;
import entity.Gallery;
import entity.ImageGallery;
import entity.Share;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class uses function in <code>ImageGalleryDAO</code> class to paginate and
 * display list image of ImageGallery object, paginate the ImageGallery by
 * PageSize and indexPage.<br>
 * - Uses function in <code>ShareDAO</code> class to get list Share object.<br>
 * - Uses function in <code>GalleryDAO</code> class to get list of Gallery
 * object.<br>
 * - Then forward to <code>gallery.jsp</code>
 *
 * @author TungCTHE141487
 */
@WebServlet(name = "GaleryController", urlPatterns = {"/GalleryController"})
public class GaleryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods, uses function in <code>ImageGalleryDAO</code> class to paginate
     * and display list image of ImageGallery object.<br>
     * The result contains a <code>entity.ImageGallery</code> objects with
     * image, galletyId.<br>
     * - Uses function in <code>GalleryDAO</code> class to get list Gallery
     * object.<br>
     * The result contains a <code>entity.Gallery</code> objects with id, name
     * description,image.<br>
     * - Uses function in <code>ShareDAO</code> class to get list Share
     * object<br>
     * The result contains a <code>entity.Share</code> objects with icon,
     * socialNetwork, url<br>
     * - Then forward to <code>gallery.jsp</code>
     *
     * @param request stores attribute: share, galleries, info, id, images,
     * maxPage, pageIndex, gal and send to JSP.<br>
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
            List<Gallery> listGalleries = galleryDAO.getTopGallery(3);
            // check list of Gallery object
            if (listGalleries.isEmpty()) {
                request.setAttribute("error", "Data  Fail !!!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                request.setAttribute("galleries", listGalleries);
            }
            //Get Share
            IShareDAO shareDAO = new ShareDAO();
            List<Share> listShare = shareDAO.getShare();
            if (listShare.isEmpty()) {
                request.setAttribute("error", "Data share error");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                request.setAttribute("share", listShare);
            }
            // Get GalleryID
            int id = 0;

            try {
                id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("id", id);
            } catch (NumberFormatException e) {

                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

            // Get images
            IImageGalleryDAO imageGalleryDAO = new ImageGalleryDAO();

            // Begin of get txtPage and pageRow
            String txtPage = request.getParameter("txtPage");
            int indexPage = 1;
            if (txtPage == null) {
                txtPage = "1";
            }
            // check indexpage is number or not
            try {
                indexPage = Integer.parseInt(txtPage);
            } catch (NumberFormatException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

            // End of get txtSearch and pageRow
            int pageSize = 8;

            Gallery gallery = galleryDAO.getGalleryByID(id);

            int rowCount = imageGalleryDAO.numberOfResult(id);
            int maxPage = (int) Math.ceil((double) rowCount / pageSize);
            // check number page out of range
            if (indexPage <= maxPage && indexPage > 0) {
                List<ImageGallery> listImageGallary = imageGalleryDAO.pagging(indexPage, pageSize, id);
                request.setAttribute("imgs", listImageGallary);
                request.setAttribute("maxPage", maxPage);
                request.setAttribute("pageIndex", indexPage);
                request.setAttribute("gallery", gallery);
            } else {
                request.setAttribute("error", "This page is not found by id = " + id);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

            request.getRequestDispatcher("gallery.jsp").forward(request, response);
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
