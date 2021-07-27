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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class uses function in <code>TimetableDAO</code> class to get date, list all
 * element of Timetable by date then forward to <code>home.jsp</code> page <br>
 * - If it has problem or exception then forward to <code>error.jsp</code> page
 *
 * @author TungCTHE141487
 */
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods, uses function in <code>TimetableDAO</code> class to get date,
     * list all Timetable, list all element of Timetable by date<br>
     * The result contain a list of <code> entity.Timetable </code> objects with
     * date, slot, teacher, classes, room <br>
     * - Then forward to <code>home.jsp</code>
     *
     * @param request stores attribute: listAll, errorMess, from, to and send to
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
        try {
            String fromDate = request.getParameter("fromdate").trim();
            String toDate = request.getParameter("todate").trim();

            ITimetableDAO timetableDAO = new TimetableDAO();

            List<Timetable> listTimetable = null;
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            // check input in text field
            if (toDate.equals("") && fromDate.equals("")) {
                request.getRequestDispatcher("HomeController").forward(request, response);
            } else if (toDate.equals("") && !fromDate.equals("")) {
                listTimetable = timetableDAO.getListSearch(changeDateFormat(fromDate), dateFormat.format(date));
                request.setAttribute("listAll", listTimetable);
            } else {
                listTimetable = timetableDAO.getListSearch(changeDateFormat(fromDate), changeDateFormat(toDate));
                request.setAttribute("listAll", listTimetable);
            }
            // check the list of Gallery object is empty
            if (listTimetable.isEmpty()) {
                request.setAttribute("from", fromDate);
                request.setAttribute("to", toDate);
                request.setAttribute("errorMess", "No Data !!!");
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } else {
                request.setAttribute("listAll", listTimetable);
            }

            request.setAttribute("from", fromDate);
            request.setAttribute("to", toDate);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMess", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    /**
     * method change date format to right format
     *
     * @param date is string
     * @return date had formated
     */
    public String changeDateFormat(String date) {
        String[] dateList = date.split("/");
        date = "";
        for (int i = dateList.length - 1; i > 0; i--) {
            date += dateList[i] + "/";
        }
        return date += dateList[0];
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
