package org.uhms.user.services;

import java.util.List;

import org.uhms.user.models.User;

public interface IUserService {

    List<User> getAllUser();

    Integer save(User user);

    Integer updateUser(User user);

    List<User> pageUserList(int page,int size);

    Integer deleteUser(int id);
}
