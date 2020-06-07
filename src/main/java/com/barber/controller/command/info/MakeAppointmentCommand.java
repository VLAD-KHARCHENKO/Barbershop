package com.barber.controller.command.info;

import com.barber.controller.command.UniCommand;
import com.barber.controller.data.Page;
import com.barber.exeption.InvalidScheduleDateException;
import com.barber.model.User;
import com.barber.model.enums.Role;
import com.barber.service.ScheduleMastersService;
import com.barber.service.ServiceFactory;
import com.barber.service.WeekScheduleDatesService;
import com.barber.view.MasterDTO;
import com.barber.view.MenuDateViewDto;
import com.barber.view.UserDTO;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.barber.controller.PageUrlConstants.*;


public class MakeAppointmentCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(MakeAppointmentCommand.class);
    private static final int LENGTH_MESSAGE = 10;
    private WeekScheduleDatesService weekScheduleDatesService;
    private ScheduleMastersService mastersService;


    public MakeAppointmentCommand() {
        this.weekScheduleDatesService = ServiceFactory.getDatesService();
        this.mastersService = ServiceFactory.getMasterService();
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        LOG.info("Get for /makeAnAppointment");
        String dateStr = request.getParameter("date");
        if (dateStr == null) {
            LOG.info("Date param is null. Send redirect.");
            return new Page(
                    request.getContextPath() + "/makeAnAppointment?date=" + LocalDate.now().format(DateTimeFormatter.ISO_DATE),
                    true
            );
        }

        LocalDate date = LocalDate.parse(dateStr);
        try {
            List<MasterDTO> mastersDTOList = mastersService.getScheduleMasters(date);
            List<MenuDateViewDto> menuDates = weekScheduleDatesService.getWeekScheduleDates(date);

            LOG.info("Master dto: " + mastersDTOList.size() + "\n" + mastersDTOList);
            request.setAttribute("menuDates", menuDates);
            request.setAttribute("schedules", mastersDTOList);


            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null && Role.ADMIN.equals(user.getRole())) {
                return new Page(MAKE_AN_APPOINTMENT_ADMIN);
            }
            return new Page(MAKE_AN_APPOINTMENT);
        } catch (InvalidScheduleDateException e) {
            LOG.warn("Get movie schedule request failed: " + e.getMessage());
            return new Page(MAKE_AN_APPOINTMENT);
        }
    }

    @Override
    protected Page performPost(HttpServletRequest request) {

        //   LOG.info("login post");
        String date = request.getParameter("Date");
        String services = request.getParameter("Choose services");
        //  System.out.println("login: " + login + ", password: " + password);
        String firstName = request.getParameter("Your name");
        String email = request.getParameter("email");
        String lastName = request.getParameter("lastName");
        String time = request.getParameter("Time");
        String password = request.getParameter("Choose Barbers");
        String phone = request.getParameter("Phone no");


        //  if (userService.validateUser(login, password)) {
        //User user = userService.getUserByLogin(login);
        // LOG.info("get user by login" + user);
        //  session.setAttribute("user", user);
        // return new Page(REDIRECT_HOME_PAGE, true);
        //   }
        //return new Page(LOGIN_PAGE, true);

        //  }
//        HttpSession session = request.getSession();
//
//        LocalDateTime date = LocalDateTime.now().withNano(0);
//        int repairTypeId = Integer.parseInt(request.getParameter("repairType"));
//        String message = request.getParameter("message");
//        User user = (User) session.getAttribute("user");
//
//        if (message.length() > LENGTH_MESSAGE) {
//            orderService.createOrder(date, repairTypeId, message, user.getId());
//            request.setAttribute("notification", "Thank you for your order!");
//            LOG.info("order : " + message);
//            return new Page("/" + MAKE_AN_APPOINTMENT);
//        }
        request.setAttribute("notification", "Message must be longer than 10 characters");
        return new Page("/" + MAKE_AN_APPOINTMENT, false);
    }
}
