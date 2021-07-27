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
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link rel="stylesheet" type="text/css" href="css/gallery.css">
    </head>
    <body>
        <div class="wrapper">  
            <jsp:include page="header.jsp"/>
            <div class="content-wrap">
                <div class="left-area">
                    <div class="name">${gallery.name}</div>
                    <div class="slide">
                        <h2>${message}</h2>
                        <c:forEach var="x" items="${imgs}">
                            <img class="gallery-big-image" src="${x.image}" style="width:100%">
                            <a id="toggleSlide" class="button" onclick="onToggleSlide()" onmouseout="onTouchend()" onmouseover="onOver()" ></a>
                        </c:forEach>
                    </div>
                    <div class="gallery-list-image">
                        <c:forEach var="x" items="${imgs}" varStatus="loop" >
                            <div class="gallery-image" >
                                <img id="choiceImage" 
                                     src="${x.image}" 
                                     onclick="showImageChoose(${loop.index})">
                            </div>
                        </c:forEach>
                    </div>
                    <div class="paging">
                        <c:if test="${maxPage<1}">
                            <h3>Not Found !!</h3>
                        </c:if>
                        <c:if test="${maxPage>1}">
                            <c:forEach begin="1" end="${maxPage}" var="i">
                                <a class="${i==pageIndex?"active":""}" href="GalleryController?txtPage=${i}&id=${id}">${i}</a>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                <div class="right-area">
                    <jsp:include page="right.jsp"/>
                </div>
            </div>
            <jsp:include page="footer.jsp"/>
            <script>
                // Window onload show image

                function showImageChoose(n) {
                    var i;
                    var x = document.getElementsByClassName("gallery-big-image");
                    if (playing === true) {
//                        toggleSlide.classList.remove("play");
//                        toggleSlide.classList.add("paused");
                        pause();
                    }
                    for (i = 0; i < x.length; i++) {
                        // Displaying image will display none
                        x[i].style.display = "none";
                    }

                    // Image which choose will display block
                    x[n].style.display = "block";
                }
                showImageChoose(0);

                // Index of the image
                var slideIndex;
                // Slideshow
                function showSlides() {
                    var i;
                    var slides = document.getElementsByClassName("gallery-big-image");

                    for (i = 0; i < slides.length; i++) {
                        slides[i].style.display = "none";
                    }
                    slides[slideIndex].style.display = "block";

                    // Move to next slide
                    slideIndex++;
                    // If the last slide, move to first
                    if (slideIndex > slides.length - 1) {
                        slideIndex = 0;
                    }
                }
                var timer;
                // Auto move to next in 1s
                timer = setInterval(showSlides, 800);
                // Default show the first slide
                showSlides(slideIndex = 0);

                // Check play or pause
                var playing = true;

                // Pause slideshow
                function pause() {
                    playing = false;
                    clearInterval(timer);
                }

                // Play slideshow
                function play() {
                    playing = true;
                    timer = setInterval(showSlides, 800);
                }

                // Choose the image
                var toggleSlide = document.getElementById("toggleSlide");

                // Change the icon if enter the button
                function onToggleSlide() {
                    if (playing === true) {
                        toggleSlide.classList.remove("play");
                        toggleSlide.classList.add("paused");
                        pause();
                    } else {
                        toggleSlide.classList.add("play");
                        toggleSlide.classList.remove("paused");
                        play();
                    }
                }

                // When user move out the mouse
                function onTouchend() {
                    if (playing === true) {
                        toggleSlide.classList.remove("play");
                    } else {
                        toggleSlide.classList.remove("paused");
                    }
                }
                function onOver() {
                    if (playing === true) {
                        toggleSlide.classList.add("play");
                    } else {
                        toggleSlide.classList.add("paused");
                    }
                }

            </script>
    </body>
</html>