package com.barber.controller.command.info;

import com.barber.controller.command.Command;
import com.barber.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.barber.controller.PageUrlConstants.BLOG_PAGE;


public class BlogCommand implements Command  {
    @Override
    public Page perform(HttpServletRequest request) {
        request.setAttribute("activeTab", "blog");
        return new Page(BLOG_PAGE);
    }
}
