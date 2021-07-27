<%-- 
    Document   : Contact
    Created on : Jun 20, 2021, 14:00:02 AM
    Author     : Chu Trieu Tung
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="/Photographer/css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="content-wrap" style="height: 460px;">
            <div class="left-area">
                <h1>${requestScope.error}</h1>
            </div>

            <div class="right-area">
                <jsp:include page="right.jsp"/>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
