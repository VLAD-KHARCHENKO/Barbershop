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
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade
    your browser</a> to improve your experience and security.</p>
<![endif]-->
<c:import url="templ/header-part.jsp"/>

<!-- header-end -->

    <!-- service_area_start -->
    <div class="service_area">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="section_title3 padding_plus text-center mb-90">
                        <h3>services</h3>
                    </div>
                </div>
            </div>
            <div class="white_bg_pos">
                    <div class="row">
                            <div class="col-xl-6">
                                <div class="single_service d-flex justify-content-between align-items-center">
                                    <div class="service_inner d-flex align-items-center">
                                        <div class="thumb">
                                                <img src="static/img/service/1.png" alt="">
                                        </div>
                                        <span>Men’s Facial</span>
                                    </div>
                                    <p>………………………..$15</p>
                                </div>
                                <div class="single_service d-flex justify-content-between align-items-center">
                                    <div class="service_inner d-flex align-items-center">
                                        <div class="thumb">
                                                <img src="static/img/service/2.png" alt="">
                                        </div>
                                        <span>Clean Cut</span>
                                    </div>
                                    <p>………………………..$15</p>
                                </div>
                                <div class="single_service d-flex justify-content-between align-items-center">
                                    <div class="service_inner d-flex align-items-center">
                                        <div class="thumb">
                                                <img src="static/img/service/3.png" alt="">
                                        </div>
                                        <span>Close Shave</span>
                                    </div>
                                    <p>………………………..$15</p>
                                </div>
                                <div class="single_service d-flex justify-content-between align-items-center">
                                    <div class="service_inner d-flex align-items-center">
                                        <div class="thumb">
                                                <img src="static/img/service/4.png" alt="">
                                        </div>
                                        <span>Razor Cut</span>
                                    </div>
                                    <p>………………………..$15</p>
                                </div>
                                <div class="single_service d-flex justify-content-between align-items-center">
                                    <div class="service_inner d-flex align-items-center">
                                        <div class="thumb">
                                                <img src="static/img/service/5.png" alt="">
                                        </div>
                                        <span>Face Massage</span>
                                    </div>
                                    <p>………………………..$15</p>
                                </div>
                            </div>
                            <div class="col-xl-6">
                                <div class="single_service d-flex justify-content-between align-items-center">
                                    <div class="service_inner d-flex align-items-center">
                                        <div class="thumb">
                                                <img src="static/img/service/6.png" alt="">
                                        </div>
                                        <span>Classic haircut</span>
                                    </div>
                                    <p>………………………..$15</p>
                                </div>
                                <div class="single_service d-flex justify-content-between align-items-center">
                                    <div class="service_inner d-flex align-items-center">
                                        <div class="thumb">
                                                <img src="static/img/service/7.png" alt="">
                                        </div>
                                        <span>Haircut and shampoo</span>
                                    </div>
                                    <p>………………………..$15</p>
                                </div>
                                <div class="single_service d-flex justify-content-between align-items-center">
                                    <div class="service_inner d-flex align-items-center">
                                        <div class="thumb">
                                                <img src="static/img/service/8.png" alt="">
                                        </div>
                                        <span>Hair treatment</span>
                                    </div>
                                    <p>………………………..$15</p>
                                </div>
                                <div class="single_service d-flex justify-content-between align-items-center">
                                    <div class="service_inner d-flex align-items-center">
                                        <div class="thumb">
                                                <img src="static/img/service/9.png" alt="">
                                        </div>
                                        <span>Beard trimming</span>
                                    </div>
                                    <p>………………………..$15</p>
                                </div>
                                <div class="single_service d-flex justify-content-between align-items-center">
                                    <div class="service_inner d-flex align-items-center">
                                        <div class="thumb">
                                                <img src="static/img/service/10.png" alt="">
                                        </div>
                                        <span>Beard and moustache</span>
                                    </div>
                                    <p>………………………..$15</p>
                                </div>
                            </div>
                            <div class="col-xl-12">
                                    <div class="book_btn text-center">
                                        <a class="boxed-btn3 popup-with-form" href="#test-form">Make an Appointment</a>
                                    </div>
                            </div>
                        </div>
            </div>
        </div>
    </div>
    <!-- service_area_end -->


    <!-- gallery_area_start -->
    <div class="gallery_area">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="section_title2 text-center mb-90">
                        <i class="flaticon-scissors"></i>
                        <h3>Our Gallery</h3>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-12">
                    <div class="gallery_active owl-carousel">
                        <div class="single_gallery">
                            <div class="thumb">
                                <img src="static/img/gallery/1.png" alt="">
                                <div class="image_hover">
                                    <a class="popup-image" href="static/img/gallery/1.png">
                                        <i class="ti-plus"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="single_gallery">
                            <div class="thumb">
                                <img src="static/img/gallery/2.png" alt="">
                                <div class="image_hover">
                                    <a class="popup-image" href="static/img/gallery/2.png">
                                        <i class="ti-plus"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="single_gallery">
                            <div class="thumb">
                                <img src="static/img/gallery/3.png" alt="">
                                <div class="image_hover">
                                    <a class="popup-image" href="static/img/gallery/3.png">
                                        <i class="ti-plus"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="single_gallery">
                            <div class="thumb">
                                <img src="static/img/gallery/1.png" alt="">
                                <div class="image_hover">
                                    <a class="popup-image" href="static/img/gallery/1.png">
                                        <i class="ti-plus"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="single_gallery">
                            <div class="thumb">
                                <img src="static/img/gallery/2.png" alt="">
                                <div class="image_hover">
                                    <a class="popup-image" href="static/img/gallery/2.png">
                                        <i class="ti-plus"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="single_gallery">
                            <div class="thumb">
                                <img src="static/img/gallery/3.png" alt="">
                                <div class="image_hover">
                                    <a class="popup-image" href="static/img/gallery/3.png">
                                        <i class="ti-plus"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- gallery_area_end -->

    <!-- video_area_start -->
    <div class="video_area">
        <div class="container-fluid p-0">
            <div class="row align-items-center no-gutters">
                <div class="col-xl-6 col-lg-6">
                    <div class="video_info">
                        <div class="about_info">
                            <div class="section_title mb-20px">
                                <span>How we Work</span>
                                <h3>Watch the Video <br>
                                    How we Work?</h3>
                            </div>
                            <p>Inspires employees and organizations to support causes they care <br>
                                about. We do this to bring more resources to the nonprofits that are <br>
                                changing our world.</p>
                            <a href="#" class="boxed-btn3">book now</a>
                        </div>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-6">
                    <div class="video_thumb">
                        <div class="video_thumb_inner">
                            <img src="static/img/gallery/video.png" alt="">
                            <a href="https://www.youtube.com/watch?v=I4NcwG-zusE" class="popup-video">
                                <i class="fa fa-play"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- video_area_end -->

    <!-- cutter_muster_start -->
    <div class="cutter_muster">
        <div class="container">
                <div class="row">
                        <div class="col-xl-12">
                            <div class="section_title2 text-center mb-90">
                                <i class="flaticon-scissors"></i>
                                <h3>Our Cutter Masters</h3>
                            </div>
                        </div>
                    </div>
            <div class="row">
                <div class="col-xl-3 col-md-6 col-lg-3">
                    <div class="single_master">
                        <div class="thumb">
                            <img src="static/img/team/1.png" alt="">
                            <div class="social_link">
                                <a href="#"><i class="fa fa-envelope"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                            </div>
                        </div>
                        <div class="master_name text-center">
                            <h3>Macau Wilium</h3>
                            <p>Massage Master</p>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6 col-lg-3">
                    <div class="single_master">
                        <div class="thumb">
                            <img src="static/img/team/2.png" alt="">
                            <div class="social_link">
                                <a href="#"><i class="fa fa-envelope"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                            </div>
                        </div>
                        <div class="master_name text-center">
                            <h3>Dan Jacky</h3>
                            <p>Mens Cut</p>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6 col-lg-3">
                    <div class="single_master">
                        <div class="thumb">
                            <img src="static/img/team/3.png" alt="">
                            <div class="social_link">
                                <a href="#"><i class="fa fa-envelope"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                            </div>
                        </div>
                        <div class="master_name text-center">
                            <h3>Luka Luka</h3>
                            <p>Mens Cut</p>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-md-6 col-lg-3">
                    <div class="single_master">
                        <div class="thumb">
                            <img src="static/img/team/4.png" alt="">
                            <div class="social_link">
                                <a href="#"><i class="fa fa-envelope"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                            </div>
                        </div>
                        <div class="master_name text-center">
                            <h3>Rona Dana</h3>
                            <p>Ladies Cut</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- cutter_muster_end -->

    <!-- find_us_area start -->
    <div class="find_us_area find_bg_1 ">
        <div class="container">
            <div class="row">
                <div class="col-xl-5 offset-xl-7 col-lg-6 offset-lg-6">
                    <div class="find_info">
                        <h3 class="find_info_title">How to Find Us</h3>
                        <div class="single_find d-flex">
                            <div class="icon">
                                <i class="flaticon-placeholder"></i>
                            </div>
                            <div class="find_text">
                                    <h3>Location</h3>
                                    <p>200, A-block, Green road, USA</p>
                            </div>
                        </div>
                        <div class="single_find d-flex">
                            <div class="icon">
                                <i class="flaticon-phone-call"></i>
                            </div>
                            <div class="find_text">
                                    <h3>Call Us</h3>
                                    <p>+10 378 478 2789</p>
                            </div>
                        </div>
                        <div class="single_find d-flex">
                            <div class="icon">
                                <i class="flaticon-paper-plane"></i>
                            </div>
                            <div class="find_text">
                                    <h3>Mail Us</h3>
                                    <p>contact@barbershop.com</p>
                            </div>
                        </div>
                        <div class="single_find">
                            <div class="book_btn">
                                <a class="popup-with-form" href="#test-form">Make an Appointment</a>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- find_us_area_end -->

<c:import url="templ/footer-part.jsp"/>
<!-- link that opens popup -->
<c:import url="templ/form-part.jsp"/>

<!-- form itself end -->

<c:import url="templ/script-part.jsp"/>
</body>

</html>