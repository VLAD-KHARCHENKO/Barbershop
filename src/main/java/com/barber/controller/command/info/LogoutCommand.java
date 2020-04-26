package com.barber.controller.command.info;

import com.barber.controller.command.Command;
import com.barber.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.barber.controller.PageUrlConstants.REDIRECT_HOME_PAGE;

public class LogoutCommand implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        request.getSession().invalidate();
        return new Page(REDIRECT_HOME_PAGE, true);
    }
}
