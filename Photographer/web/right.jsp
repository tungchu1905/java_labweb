<%-- 
    Document   : Contact
    Created on : Jun 20, 2021, 14:00:02 AM
    Author     : Chu Trieu Tung
--%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <div class="right-wrapper">
            <div class="right-title">Share this page</div>
            <div class="right-social">
                <h2>${errShare}</h2>
                <c:forEach var="x" items="${share}">
                    <p>
                        <img class="icon" src="${x.icon}" >
                        <a href="#" class="right-social social-link ">Share on ${x.socialNetwork}</a>                    
                    </p>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
