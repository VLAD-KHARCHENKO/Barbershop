package com.barber.service;

import com.barber.model.enums.Role;
import com.barber.view.UserDTO;
import com.barber.model.User;
import com.barber.model.enums.DaoType;
import com.barber.repository.DaoFactory;
import com.barber.repository.EntityDao;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;


public class UserService {
    private EntityDao<User> userDao;
    private static final Logger LOG = Logger.getLogger(UserService.class);

    public UserService() {
        this.userDao = DaoFactory.getEntityDao(DaoType.USER);
    }

    public List<UserDTO> getAll() {
        List<User> all = userDao.getAll();
        return mapToUserDTO(all);
    }

    public boolean validateUser(String login, String password) {
        User user = userDao.getByField(login, false);
        LOG.info("Get user by login:" + user);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                LOG.info("user validate");
                return true;
            }
        }
        return false;
    }
    public User getUserByLogin(String login) {
        return userDao.getByField(login, false);
    }

    public boolean validateLogin(String login) {
        List<User> all = userDao.getAll();
        for (User user : all) {
            if (user.getLogin().equals(login)) {
                System.out.println("Not validate login: " + user.getLogin());
                return false;
            }
        }
        return true;
    }


    public boolean validatePassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) return true;
        return false;
    }

    public User registrationUser(String firstName, String lastName, String phone, String login, String password) {

        User newUser = new User(firstName, lastName, phone, login, password, Role.CUSTOMER);
        LOG.info(newUser);
        userDao.create(newUser);
        return newUser;
    }


    private List<UserDTO> mapToUserDTO(List<User> all) {
        return all.stream().map(users -> {
            User userProfile = userDao.getById(users.getId(), false);
            UserDTO userDTO = new UserDTO();

            userDTO.setId(userProfile.getId());
            userDTO.setFirstName(userProfile.getFirstName());
            userDTO.setLastName(userProfile.getLastName());
            userDTO.setPhone(userProfile.getPhone());
            userDTO.setLogin(userProfile.getLogin());
            userDTO.setRole(userProfile.getRole());
            return userDTO;
        }).collect(Collectors.toList());
    }


}
