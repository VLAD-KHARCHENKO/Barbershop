package com.barber.service;

public class ServiceFactory {
    private ServiceFactory() {
    }

    private static FeedbackService feedbackService = new FeedbackService();
    private static UserService userService = new UserService();
    private static final WeekScheduleDatesService datesService = new WeekScheduleDatesService();

    public static FeedbackService getFeedbackService() {
        return feedbackService;
    }

    public static UserService getUserService() {
        return userService;
    }
    public static WeekScheduleDatesService getDatesService() {
        return datesService;
    }


}
