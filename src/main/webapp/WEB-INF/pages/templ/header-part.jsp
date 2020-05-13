<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<!-- header-start -->
<header>
    <div class="header-area ">
        <div id="sticky-header" class="main-header-area">
            <div class="container-fluid p-0">
                <div class="row align-items-center no-gutters">
                    <div class="col-xl-3 col-lg-3">
                        <div class="logo-img">
                            <a href="index">
                                <img src="static/img/logo.png" alt="">
                            </a>
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-6">
                        <div class="main-menu  d-none d-lg-block">
                            <nav>
                                <ul id="navigation">

                                    <c:set var="name" value='${activeTab}'/>
                                    <li <c:if test="${name == 'home'}">class="active"</c:if>><a href=""><fmt:message
                                        key="home"/></a>

                                    <li <c:if test="${name == 'about'}">class="active"</c:if>><a href="about"><fmt:message
                                        key="about"/></a>

                                    <li <c:if test="${name == 'service'}">class="active"</c:if>><a href="service"><fmt:message
                                        key="service"/></a>

                                    <li <c:if test="${name == 'blog'}">class="active"</c:if>><a href="#"><fmt:message
                                        key="blog"/><i class="ti-angle-down"></i></a>
                                    <ul class="submenu">
                                        <li><a href="blog"><fmt:message key="blog"/></a></li>
                                        <li><a href="single-blog"><fmt:message key="single.blog"/></a></li>
                                    </ul>
                                    </li>
                                    <li <c:if test="${name == 'pages'}">class="active"</c:if>><a href="#"><fmt:message
                                        key="pages"/></a>
                                    <ul class="submenu">
                                        <li><a href="elements"><fmt:message key="elements"/><i class="ti-angle-down"></i></a></li>
                                    </ul>
                                    </li>
                                    <li <c:if test="${name == 'contact'}">class="active"</c:if>><a href="contact"><fmt:message
                                        key="contact"/></a>
                                    <li <c:if test="${name == 'feedback'}">class="active"</c:if>><a href="feedback"><fmt:message
                                        key="feedback"/></a>


                                    <li>   <c:choose>
                                        <c:when test="${not empty user}">
                                            <a href="logout">
                                                <fmt:message key="logout"/>
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                   <a href="login"><fmt:message key="login"/></a>
                                        </c:otherwise>
                                    </c:choose></li>





                                    <li><c:choose>
                                        <c:when test="${locale=='uk_UA'}"><a href="language?locale=en" class="text-uppercase">en</a>  </c:when>
                                        <c:otherwise>
                                    <a href="language?locale=uk_UA" class="text-uppercase">ua</a>
                                        </c:otherwise>
                                    </c:choose></li>


                                </ul>

                            </nav>
                        </div>
                    </div>
                    <div class="col-xl-3 col-lg-3 d-none d-lg-block">
                        <div class="book_room">
                            <div class="book_btn d-none d-lg-block">
                                <a href="makeAnAppointment"><fmt:message key="make.an.appointment"/></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="mobile_menu d-block d-lg-none"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</header>
<!-- header-end -->