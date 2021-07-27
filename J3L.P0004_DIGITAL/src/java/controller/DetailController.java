/*
 * Copyright(C) 2005,  FPT University
 * J3.L.P0004
 * Digital News
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-05-16     1.0              TungCTHE141487      First Implement
 */
package controller;

import dao.IDigitalDAO;
import dao.impl.DigitalNewsDAO;
import entity.Digital;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class uses function in <code>DigitalNewsDAO</code> class to get Digital News
 * by id then forward to <code>Detail.jsp</code>
 *
 * @author TungCTHE141487
 */
@WebServlet(name = "DetailController", urlPatterns = {"/DetailController"})
public class DetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods, using function in <code>DigitalNewsDAO</code> class to get
     * Digital News by id.<br>
     * The result contains a <code>entity.Digital</code> objects with id, title,
     * description, images, author, timePost,shortDes then forward to
     * <code>Detail.jsp</code>
     *
     * @param request is the <code>javax.servlet.http.HttpServletRequest</code>
     * object
     * @param response is the
     * <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs, it is the
     * <code> javax.servlet.ServletException</code> object
     * @throws IOException if an I/O error occurs, it is the
     * <code>java.io.IOException</code> object
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            IDigitalDAO digitalDAO = new DigitalNewsDAO();
            // get list top news
            List<Digital> listRecent = digitalDAO.getTop(6);
            // get the newest news
            request.setAttribute("top1", listRecent.remove(0));
            request.setAttribute("top5", listRecent);
            int id = Integer.parseInt(request.getParameter("id"));
            // check exist of id
            if (digitalDAO.checkExistId(id)) {
                Digital digital = digitalDAO.getNews(id);
                request.setAttribute("detail", digital);
                request.getRequestDispatcher("Detail.jsp").forward(request, response);
            } else {
                String notify = "No news found that have id = " + id;
                request.setAttribute("errormess", notify);
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errormess", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request is the <code> HttpServletRequest </code>
     * object
     * @param response servlet response is the <code> HttpServletResponse
     * </code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request is the <code> HttpServletRequest </code>
     * object
     * @param response servlet response is the <code> HttpServletResponse
     * </code> object
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
