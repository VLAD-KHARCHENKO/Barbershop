<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<!-- form itself end-->
<form id="login-form" class="white-popup-block mfp-hide">
    <div class="popup_box ">
        <div class="popup_inner">
            <h3>Login</h3>
            <form action="#">
                <div class="row">
                        <input type="email" placeholder="Your email">
                    <input type="password" placeholder="Password">

                </div>

                    <div class="col-xl-12">
                        <button type="submit" class="boxed-btn3">Login</button>
                    </div>





            </form>
            <div class="col-xl-12"><a class="popup-with-form" href="#registration-form">Registration</a>  </div>
        </div>
    </div>
</form>
