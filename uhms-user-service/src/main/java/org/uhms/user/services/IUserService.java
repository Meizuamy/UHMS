package org.uhms.user.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.uhms.user.models.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUser();

    Integer save(User user);

    Integer updateUser(User user);

    List<User> pageUserList(int page,int size);

    Integer deleteUser(Long id);
}
