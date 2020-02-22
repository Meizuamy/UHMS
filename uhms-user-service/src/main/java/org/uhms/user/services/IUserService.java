package org.uhms.user.services;

import org.uhms.user.models.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUser();

    void save(User user);

    void updateUser(User user);
}
