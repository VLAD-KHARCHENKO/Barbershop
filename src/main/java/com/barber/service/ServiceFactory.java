package com.barber.service;

public class ServiceFactory {
    private ServiceFactory() {
    }

    private static FeedbackService feedbackService = new FeedbackService();
    private static UserService userService = new UserService();


    public static FeedbackService getFeedbackService() {
        return feedbackService;
    }

    public static UserService getUserService() {
        return userService;
    }

}
