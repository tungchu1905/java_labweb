<%-- 
    Document   : home
    Created on : Jul 23, 2021, 5:58:11 PM
    Author     : chutr
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h2> &#128197; <a style="text-decoration: none;" href="HomeController"> Time to Date </a> </h2>
        <form action="SearchController" method="get">
            <div class="search">
                <table >
                    <tr>
                        <td>From Date</td>
                        <td>To Date</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td> <input id="fromd" class="txt" type="text" name="fromdate" value="${from}" required="" maxlength="15" pattern="^[\s]{0,15}(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/([0-9]{4})[\s]{0,15}$" title="You have input right format dd/mm/yyyy">
                        </td>
                        <td> <input id="tod" class="txt" type="text" name="todate" value="${to}" maxlength="15" pattern="^[\s]{0,15}(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/([0-9]{4})[\s]{0,15}$" title="You have input right format dd/mm/yyyy">
                        </td>
                        <td> <input  class="btn" type="submit" value="Search">&#128106;<a href="AddictionController">Add Timetable </a>
                        </td>
                    </tr>

                </table>
                        

            </div>

        </form>


        <div>
            <table class="content">
                <tr >
                    <td style="text-align: center;">&#128197; Date </td>
                    <td >&#128336; Tiết </td>
                    <td >&#128336; Time </td>
                    <td> Class </td>
                    <td > Teacher </td>
                    <td > Room </td>
                </tr>

                <c:forEach items="${listAll}" var="i">
                    <tr>
                        <td>${i.date}</td>
                        <td>${i.slot}</td>
                        <td>${i.time}</td>
                        <td style="color: background;">${i.classes}</td>
                        <td>${i.teacher}</td>
                        <td>${i.room}</td>
                    </tr>
                </c:forEach>
            </table>
            ${errorMess}
            <div class="paging">
                <c:if test="${maxPage>1}">
                    <c:forEach begin="1" end="${maxPage}" var="i">
                            <a href="HomeController?page=${i}">${i}</a>
                    
                    </c:forEach>
                </c:if>
            </div>
        </div>
                        
    </body>
</html>
