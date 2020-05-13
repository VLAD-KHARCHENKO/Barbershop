package com.barber.controller.command.info;

import com.barber.controller.command.UniCommand;
import com.barber.controller.data.Page;
import com.barber.model.User;
//import com.barber.service.ServiceFactory;
//import com.barber.service.UserService;
import com.barber.service.ServiceFactory;
import com.barber.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.barber.controller.PageUrlConstants.LOGIN_PAGE;
import static com.barber.controller.PageUrlConstants.REDIRECT_HOME_PAGE;

public class LoginCommand extends UniCommand {
    private UserService userService;
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);

    public LoginCommand() {
       this.userService = ServiceFactory.getUserService();
   }

    @Override
    protected Page performGet(HttpServletRequest request) {
        return new Page(LOGIN_PAGE);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        LOG.info("login post");
      String login = request.getParameter("login");
        String password = request.getParameter("password");

     HttpSession session = request.getSession();

      if (userService.validateUser(login, password)) {
          User user = userService.getUserByLogin(login);
           LOG.info("get user by login" + user);
           session.setAttribute("user", user);
           return new Page(REDIRECT_HOME_PAGE, true);
    }
     return new Page(LOGIN_PAGE, true);

    }
}
