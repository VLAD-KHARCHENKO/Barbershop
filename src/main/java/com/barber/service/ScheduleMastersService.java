package com.barber.service;

import com.barber.model.*;
import com.barber.model.enums.BookingStatus;
import com.barber.model.enums.DaoType;
import com.barber.repository.DaoFactory;
import com.barber.repository.EntityDao;
import com.barber.view.AppointmentTimeViewDto;
import com.barber.view.MasterDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleMastersService {

    private static EntityDao<User> userDao;
    private static EntityDao<Master> masterDao;
    private static EntityDao<Skills> skillsDao;
    private static EntityDao<Service> serviceDao;
    private static EntityDao<MasterSсhedules> scheduleDao;


    public ScheduleMastersService() {
        this.userDao = DaoFactory.getEntityDao(DaoType.USER);
        this.masterDao = DaoFactory.getEntityDao(DaoType.MASTER);
        this.skillsDao = DaoFactory.getEntityDao(DaoType.SKILLS);
        this.serviceDao = DaoFactory.getEntityDao(DaoType.SERVICE);
        this.scheduleDao = DaoFactory.getEntityDao(DaoType.MASTERSCHEDULES);
    }

    public List<MasterDTO> getScheduleMasters(LocalDate date) {
        List<Master> allMasters = masterDao.getAll(true);
        return allMasters.stream().map(master -> {
            MasterDTO masterDTO = new MasterDTO();
            masterDTO.setId(master.getId());
            masterDTO.setMaster(userDao.getById(master.getUserId(), true));
            masterDTO.setPhotoImgPath(master.getPhoto());
            List<Skills> skills = skillsDao.getAllById(master.getId(), true);
            masterDTO.setServicesList(ScheduleMastersService.getListServices(skills));
            masterDTO.setAppointmentSessionTime(ScheduleMastersService.getListSchedule(master.getId(), date));
            return masterDTO;
        }).collect(Collectors.toList());
    }

    private static List<AppointmentTimeViewDto> getListSchedule(int id, LocalDate date) {
        List<MasterSсhedules> masterSсhedules = scheduleDao.getAllById(id, true);
        return masterSсhedules.stream().map(scheduleMaster -> {
            if (!scheduleMaster.getStartAt().toLocalDate().equals(date)) return null;
            AppointmentTimeViewDto appointmentTimeViewDto = new AppointmentTimeViewDto();
            appointmentTimeViewDto.setId(scheduleMaster.getId());
            appointmentTimeViewDto.setUser(userDao.getById(scheduleMaster.getUserId(), true));
            appointmentTimeViewDto.setStartAt(scheduleMaster.getStartAt().toLocalTime());
            if (scheduleMaster.getBookingStatus().equals(BookingStatus.BOOKED)) {
                appointmentTimeViewDto.setBooked(true);
            } else {
                appointmentTimeViewDto.setBooked(false);
            }
            return appointmentTimeViewDto;
        }).collect(Collectors.toList());

    }

    private static List<Service> getListServices(List<Skills> skills) {
        return skills.stream().map(skill -> {
            Service service = serviceDao.getById(skill.getServiceId(), true);
            return service;
        }).collect(Collectors.toList());


    }

}
