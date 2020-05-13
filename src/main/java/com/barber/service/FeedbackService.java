package com.barber.service;

import com.barber.view.FeedbackDTO;
import com.barber.view.UserDTO;
import com.barber.model.Feedback;
import com.barber.model.User;
import com.barber.model.enums.DaoType;
import com.barber.repository.DaoFactory;
import com.barber.repository.EntityDao;

import org.apache.log4j.Logger;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FeedbackService {
    private static final Logger LOG = Logger.getLogger(FeedbackService.class);

    private EntityDao<User> userDao;
    private EntityDao<Feedback> feedbackDao;

    public FeedbackService() {
        this.userDao = DaoFactory.getEntityDao(DaoType.USER);
        this.feedbackDao = DaoFactory.getEntityDao(DaoType.FEEDBACK);

    }


    public List<FeedbackDTO> getAll() {
        List<Feedback> all = feedbackDao.getAll(true);
        return all.stream().map(feedback -> {
            User customer = userDao.getById(feedback.getUserId(), false);
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            feedbackDTO.setId(feedback.getId());
            feedbackDTO.setDate(feedback.getDate());
            feedbackDTO.setFeedback(feedback.getFeedback());

            UserDTO userDTO = new UserDTO();
            userDTO.setId(customer.getId());
            userDTO.setName(customer.getFirstName() + " " + customer.getLastName());
            feedbackDTO.setCustomer(userDTO);
            return feedbackDTO;
        }).collect(Collectors.toList());
    }
    public void setFeedback(LocalDateTime date, String message, int userId) {
        LOG.info("feedback: " + date+ message + userId);
        Feedback feedback = new Feedback(date, message, userId);

        feedbackDao.create(feedback);
        LOG.info("feedback create : " + feedback.toString());
    }

}
