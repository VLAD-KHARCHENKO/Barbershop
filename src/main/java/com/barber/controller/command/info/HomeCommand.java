package com.barber.controller.command.info;

import com.barber.controller.command.Command;
import com.barber.controller.data.Page;
import com.barber.service.FeedbackService;
import com.barber.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;

import static com.barber.controller.PageUrlConstants.HOME_PAGE;

public class HomeCommand implements Command {

    private FeedbackService feedbackService;

    public HomeCommand() {
        this.feedbackService = ServiceFactory.getFeedbackService();
    }

    @Override
    public Page perform(HttpServletRequest request) {
        request.setAttribute("feedback", feedbackService.getAll());
        request.setAttribute("activeTab", "home");
        return new Page(HOME_PAGE);

    }

}
