package com.barber.controller.command.info;

import com.barber.controller.command.UniCommand;
import com.barber.controller.data.Page;
import com.barber.model.User;
import com.barber.service.ServiceFactory;
import com.barber.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.barber.controller.PageUrlConstants.*;

public class RegistrationCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(RegistrationCommand.class);
    private UserService userService;

    public RegistrationCommand() {
        this.userService = ServiceFactory.getUserService();
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        {
            return new Page(REGISTRATION_PAGE) ;}
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        LOG.info("Registration firstName: " + firstName + ", lastName" + lastName +
                ", phone" + phone + ", login: " + login + ", password: " + password);

        HttpSession session = request.getSession();

        if (userService.validateLogin(login) && userService.validatePassword(password, confirmPassword)) {

            User newUser = userService.registrationUser(firstName, lastName, phone, login, password);
            LOG.info("registration user: + " + newUser);

            User user = userService.getUserByLogin(login);
            session.setAttribute("user", user);
            LOG.info("registration user setAttribute: + " + user);
            return new Page(REDIRECT_HOME_PAGE, true);
        }
        request.setAttribute("notification", "Not valid login or password");
        return new Page(LOGIN_PAGE, false);
    }
}
