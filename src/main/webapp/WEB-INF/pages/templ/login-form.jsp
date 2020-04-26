<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<!-- form itself end-->
<form id="login-form" class="white-popup-block mfp-hide" action="login" method="post">
    <div class="popup_box ">
        <div class="popup_inner">
            <h3>Login</h3>

                <div class="row">
                        <input type="email" type="text" name="login" placeholder="Your email">
                    <input type="password"  name="password"  placeholder="Password">

                </div>

                    <div class="col-xl-12">
                        <button type="submit" class="boxed-btn3">Login</button>
                    </div>


            <div class="col-xl-12"><a href="registration"><fmt:message key="registration"/></a>  </div>
        </div>
    </div>
</form>
