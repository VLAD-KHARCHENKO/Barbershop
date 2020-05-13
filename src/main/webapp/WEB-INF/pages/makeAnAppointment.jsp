<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html class="no-js" lang="zxx">

<head>

    <title>Barber</title>
    <c:import url="templ/head-part.jsp"/>

</head>

<body>
    <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

    <!-- header-start -->
    <c:import url="templ/header-part.jsp"/>


       <!-- header-end -->




    <div class="bradcam_area breadcam_bg overlay2">
            <h3>Make an Appointment</h3>
        </div>
        <!-- bradcam_area_end -->
    <!-- Second level menu -->
    <div class="col-xl-6 col-lg-6">
        <div class="main-menu  d-none d-lg-block">
            <nav>
    <ul >
        <c:forEach items="${menuDates}" var="menuDate">
            <li <c:if test="${menuDate.isActive()}">class="active"</c:if>>
            <a href="makeAnAppointment${menuDate.getIsoDate()}">
                <fmt:message key="week.day.${menuDate.getDayOfWeek()}"/>
                ${menuDate.getFormattedDate()}</a></li>
        </c:forEach>
    </ul>
            </nav>
        </div>
    </div>



    <c:if test="${schedules.size() == 0}">
        <h2 style="text-align: center; color: gray; padding-top: 150px;">
            <fmt:message key="schedule.empty.msg.part.one" /><br> <fmt:message key="schedule.empty.msg.part.two" /></h2>
    </c:if>
    <c:forEach items="${sessions}" var="movie">
        <div class="movie-card">
            <div class="movie-card__container">
                <a href="${movie.trailerUrl}" target="_blank">
                    <div class="movie-cover">
                        <img class="play-icon" src="static/img/play.png" alt="cover"/>
                        <img class="cover-img"
                             src="${movie.coverImgPath}"
                             alt="cover"/>
                    </div>
                </a>

                <div class="movie-card__background">
                    <img class="background-img"
                         src="${movie.backgroundImgPath}">
                </div>

                <div class="movie-description">
                    <div class="movie-title">${movie.title}</div>
                    <p class="movie-duration">
                        <fmt:message key="schedule.duration"/>:
                        ${movie.duration}<fmt:message key="schedule.min"/>
                    </p>

                    <c:forEach items="${movie.movieSessionTimes}" var="time">
                        <a class="tag" href="movie-session/${time.getMovieSessionId()}">${time.getTimeView()}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </c:forEach>

    <form id="makeAppointment-form" class="newsletter_form">
        <div class="popup_box ">
            <div class="popup_inner">
                <h3>Make an Appointment</h3>
                <form action="#">
                    <div class="row">
                        <div class="col-xl-6 col-md-6">
                            <input id="datepicker" placeholder="Date">
                        </div>
                        <div class="col-xl-6 col-md-6">
                            <input id="timepicker" placeholder="time">
                        </div>
                        <div class="col-xl-6 col-md-6">
                            <select class="form-select wide" id="default-select" class="">
                                <option data-display="Choose services">Choose services 1</option>
                                <option value="1">Choose services 2</option>
                                <option value="2">Choose services 3</option>
                                <option value="3">Choose services 4</option>
                            </select>
                        </div>
                        <div class="col-xl-6 col-md-6">
                            <select class="form-select wide" id="default-select" class="">
                                <option data-display="Choose Barbers">Choose Barbers</option>
                                <option value="1">Zaki</option>
                                <option value="2">Ronky</option>
                                <option value="3">kalu</option>
                            </select>
                        </div>
                        <div class="col-xl-6 col-md-6">
                            <input type="text" placeholder="Your name">
                        </div>
                        <div class="col-xl-6 col-md-6">
                            <input type="text" placeholder="Phone no">
                        </div>
                        <div class="col-xl-12">
                            <input type="email" placeholder="Your email">
                        </div>
                        <div class="col-xl-12">
                            <button type="submit" class="boxed-btn3">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </form>

    <c:import url="templ/footer-part.jsp"/>
    <!-- link that opens popup -->
    <c:import url="templ/form-part.jsp"/>

    <!-- form itself end -->

    <c:import url="templ/script-part.jsp"/>

</body>

</html>