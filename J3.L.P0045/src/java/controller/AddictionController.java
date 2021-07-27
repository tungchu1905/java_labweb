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

import dao.IClassDAO;
import dao.IRoomDAO;
import dao.ISlotDAO;
import dao.ITimetableDAO;
import dao.impl.ClassDAO;
import dao.impl.RoomDAO;
import dao.impl.SlotDAO;
import dao.impl.TimetableDAO;
import entity.Classes;
import entity.Room;
import entity.Slot;
import entity.Timetable;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class uses function in <code>ClassDAO</code> class to get class name of Class
 * object<br>
 * - Uses function in <code>RoomDAO</code> class to get room name of Room
 * object<br>
 * - Uses function in <code>SlotDAO</code> class to get all slot of Slot object
 * in <code>GET</code> method then forward to <code>add.jsp</code><br>
 * - Uses function in <code>TimetableDAO</code> class get date, slot, class,
 * teacher, room to check exist timetable and add new timetable of Timetable
 * object in <code>POST</code> method then forward to
 * <code>HomeController</code> <br>
 * If it has problem or exception then forward to <code>error.jsp</code> page
 *
 * @author TungCTHE141487
 */
@WebServlet(name = "AddictionController", urlPatterns = {"/AddictionController"})
public class AddictionController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request the <code>javax.servlet.http.HttpServletRequest</code>
     * object
     * @param response the <code>javax.servlet.http.HttpServletResponse</code>
     * object
     * @throws ServletException if a servlet-specific error occurs, it is the
     * <code> javax.servlet.ServletException</code> object
     * @throws IOException if an I/O error occurs, it is the
     * <code>java.io.IOException</code> object
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    /**
     * Handles the HTTP <code>GET</code> method, uses function in
     * <code>TimetableDAO</code> class to get room name, class name of Timetable
     * object<br>
     * The result contain a list of <code> entity.Timetable </code> objects with
     * date, slot, teacher, classes, room <br>
     * - Uses function in <code>SlotDAO</code> class to get all slot of Slot
     * object<br>
     * The result contain a list of <code> entity.Gallery</code> objects with
     * slot, time<br>
     * - Then forward to <code>add.jsp</code>
     *
     *
     * @param request stores attribute: slot, room, class, errorMess and send to
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ISlotDAO slotDAO = new SlotDAO();
            IClassDAO classDAO = new ClassDAO();
            IRoomDAO roomDAO = new RoomDAO();
            // get list data of slot, room, class
            List<Slot> listSlot = slotDAO.getAllSlot();
            List<Room> listRoom = roomDAO.getRoomName();
            List<Classes> listClass = classDAO.getClassName();
            // set attribute to list of slot, room, class
            request.setAttribute("slot", listSlot);
            request.setAttribute("room", listRoom);
            request.setAttribute("classes", listClass);
            request.getRequestDispatcher("add.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMess", e.getMessage());
            request.getRequestDispatcher("error").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method, uses function in
     * <code>TimetableDAO</code> class get date, slot, class, teacher, room to
     * check exist timetable and add new timetable of Timetable object<br>
     * The result contain a list of <code> entity.Timetable </code> objects with
     * date, slot, teacher, classes, room <br>
     * - Then forward to <code>HomeController</code>
     *
     * @param request stores attribute: errorMess and send to JSP.<br>
     * It is the <code>javax.servlet.http.HttpServletRequest</code> object
     * @param response is used to store the attribute and sends a response to
     * client's browser.<br>
     * It is the <code>javax.servlet.http.HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs, it is the
     * <code> javax.servlet.ServletException</code> object
     * @throws IOException if an I/O error occurs, it is the
     * <code>java.io.IOException</code> object
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ITimetableDAO timetableDAO = new TimetableDAO();
            String date = request.getParameter("date").trim();
            String slot = request.getParameter("slot");
            String classes = request.getParameter("class");
            String teacher = request.getParameter("teacher").trim();
            String room = request.getParameter("room");

            if (new SimpleDateFormat("dd/MM/yyyy").parse(date).before(new Date())) {
                request.setAttribute("errorMess", "This date is passed. Please check timetable again");
                ISlotDAO slotDAO = new SlotDAO();
                IClassDAO classDAO = new ClassDAO();
                IRoomDAO roomDAO = new RoomDAO();
                List<Slot> listSlot = slotDAO.getAllSlot();
                List<Room> listRoom = roomDAO.getRoomName();
                List<Classes> listClass = classDAO.getClassName();
                request.setAttribute("slot", listSlot);
                request.setAttribute("room", listRoom);
                request.setAttribute("classes", listClass);
                request.setAttribute("teacher", teacher);
                request.setAttribute("date", date);
                request.getRequestDispatcher("add.jsp").forward(request, response);
            } else {
                Timetable timetableCheck1 = timetableDAO.checkExistRoomTimeTable(changeDateFormat(date), classes, room);
                Timetable TimetableCheck2 = timetableDAO.checkExistTeacherTimeTable(changeDateFormat(date), classes, teacher);

                if (timetableCheck1 == null && TimetableCheck2 == null && !teacher.equals("") && !date.equals("")) {
                    timetableDAO.addTimetable(changeDateFormat(date), slot, classes, teacher, room);

                    request.getRequestDispatcher("HomeController").forward(request, response);

                } else {
                    request.setAttribute("errorMess", "This timetable is already exist. Please check timetable again");
                    ISlotDAO slotDAO = new SlotDAO();
                    IClassDAO classDAO = new ClassDAO();
                    IRoomDAO roomDAO = new RoomDAO();
                    List<Slot> listSlot = slotDAO.getAllSlot();
                    List<Room> listRoom = roomDAO.getRoomName();
                    List<Classes> listClass = classDAO.getClassName();
                    request.setAttribute("slot", listSlot);
                    request.setAttribute("room", listRoom);
                    request.setAttribute("classes", listClass);
                    request.setAttribute("date", date);
                    request.setAttribute("teacher", teacher);

                    request.getRequestDispatcher("add.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            request.setAttribute("errorMess", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * method change date format to right format
     *
     * @param date is <code>string</code>
     * @return date had formated
     */
    public String changeDateFormat(String date) {
        String[] dateList = date.split("/");
        date = "";
        for (int i = dateList.length - 1; i > 0; i--) {
            date += dateList[i] + "-";
        }
        return date += dateList[0];
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
