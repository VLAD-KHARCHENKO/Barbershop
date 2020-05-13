package com.barber.controller.command.info;

import com.barber.controller.command.UniCommand;
import com.barber.controller.data.Page;
import com.barber.model.User;
import com.barber.service.FeedbackService;
import com.barber.service.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

import static com.barber.controller.PageUrlConstants.FEEDBACK_PAGE;

public class FeedbackCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(FeedbackCommand.class);
    private static final int LENGTH_MESSAGE = 10;
    private FeedbackService feedbackService;

    public FeedbackCommand() {
        this.feedbackService = ServiceFactory.getFeedbackService();
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        request.setAttribute("feedback", feedbackService.getAll());
        request.setAttribute("activeTab", "feedback");
        return new Page(FEEDBACK_PAGE);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String message = request.getParameter("message");
        LocalDateTime date = LocalDateTime.now().withNano(0);
        User user = (User) session.getAttribute("user");
        LOG.info("feedback : " + message);
        if (message.length() > LENGTH_MESSAGE) {
            feedbackService.setFeedback(date, message, user.getId());
            request.setAttribute("notification", "Thank you for your feedback!");
            LOG.info("feedback : " + message);
            return new Page("/" + FEEDBACK_PAGE);
        }
        request.setAttribute("notification", "Message must be longer than 10 characters");
        return new Page("/" + FEEDBACK_PAGE, false);
    }
}
