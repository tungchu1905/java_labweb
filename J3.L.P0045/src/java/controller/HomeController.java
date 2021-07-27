/*
 * Copyright(C) 2005,  FPT University
 * J3.L.P0045
 * Timetable
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-07-23    1.0              TungCTHE141487      First Implement
 */
package controller;

import dao.ITimetableDAO;
import dao.impl.TimetableDAO;
import entity.Timetable;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class uses function in <code>TimetableDAO</code> class to get all timetable
 * element of Timetable object, paginate the Timetable by PageSize and indexPage
 * then forward to <code>home.jsp</code><br>
 * - If it has problem or exception then forward to <code>error.jsp</code> page
 *
 * @author TungCTHE141487
 */
@WebServlet(urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods, uses function in <code>TimetableDAO</code> class to all
     * timetable element of Timetable object, paginate the Timetable by PageSize
     * and indexPage <br>
     * The result contain a list of <code> entity.Timetable </code> objects with
     * date, slot, teacher, classes, room <br>
     * - Then forward to <code>home.jsp</code>
     *
     * @param request stores attribute: listAll, errorMess and send to JSP.<br>
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

            ITimetableDAO timetableDAO = new TimetableDAO();
            //get all timetable element
            List<Timetable> listTimetable = timetableDAO.getAllTimetable();

            // check the list of Gallery object is empty
            if (listTimetable.isEmpty()) {
                request.setAttribute("errorMess", "Data  Fail !!!");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                request.setAttribute("listAll", listTimetable);
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
                request.setAttribute("errorMess", e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            //Number of items in a page
            int pageSize = 7;

            //All number of items
            int rowCount = timetableDAO.numberOfResult();
            //Maximum of page 
            int maxPage = rowCount / pageSize + (rowCount % pageSize > 0 ? 1 : 0);
            // check index of page with the maximum of page
            if (indexPage <= maxPage && indexPage > 0) {
                listTimetable = timetableDAO.pagging(indexPage, pageSize);
                request.setAttribute("listAll", listTimetable);
                request.setAttribute("maxPage", maxPage);
                request.setAttribute("pageIndex", indexPage);

            } else {
                request.setAttribute("errorMess", "Data not found! Because index page is out of rage");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            // set list of timetable
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMess", e.getMessage());
            request.getRequestDispatcher("error").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
