package com.barber.service;

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
