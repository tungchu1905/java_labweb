<%-- 
    Document   : add
    Created on : Jul 23, 2021, 9:34:21 PM
    Author     : chutr
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/add.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1><a href="HomeController" style="text-decoration: none;">&#128197;</a> Add Timetable</h1>
        <h3 style="color: red;">${errorMess}</h3>
        <form action="AddictionController" method="post">
            <table>
                <tr class="checked">
                    <td>
                        Date:
                    </td>
                    <td>
                        <input  name="date" type="text" required="" maxlength="15" value="${date}"  pattern="^[\s]{0,15}(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/([0-9]{4})[\s]{0,15}$" title="You have input right format dd/mm/yyyy"> (*)
                    </td>
                </tr>
                <tr>
                    <td>
                        Slot:
                    </td>
                    <td>
                        <select name="slot">
                            <c:forEach items="${slot}" var="s">
                                <option value="${s.slot}">${s.slot}</option> 
                            </c:forEach></select> (*)
                    </td>
                </tr>
                <tr class="checked">
                    <td>
                        Room:
                    </td>
                    <td>
                        <select name="room">
                            <c:forEach items="${room}" var="t">
                                <option value="${t.roomId}">${t.roomName}</option> 
                            </c:forEach>
                        </select> (*)
                    </td>
                </tr><tr>
                    <td>
                        Teacher:
                    </td>
                    <td>
                        <input name="teacher" type="text" value="${teacher}" required maxlength="30" pattern="^(?=.*[a-z])[a-zA-Z0-9\s]+" title="You have input right format"> (*)
                    </td>
                </tr><tr class="checked">
                    <td>
                        Class/Course
                    </td>
                    <td>
                        <select name="class">
                            <c:forEach items="${classes}" var="c">
                                <option value="${c.classId}">${c.className}</option> 
                            </c:forEach> 
                        </select> (*)
                    </td>
                </tr>
                <tr class="checked">
                    <td style="color: red;">The field (*) is required</td>
                    <td ><input class="sub" type="submit" value="Save"></td>
                </tr>

            </table>

        </form>
    </body>
</html>
