package org.uhms.user.services.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uhms.user.mapper.UserMapper;
import org.uhms.user.models.User;
import org.uhms.user.services.IUserService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.findAll();
    }

    @Override
    public Integer save(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Integer updateUser(User user) {
       return userMapper.updateUserById(user);
    }

    @Override
    public List<User> pageUserList(int page,int size) {
        return userMapper.pageUserList(page*size,size);
    }

    @Override
    public Integer deleteUser(int id) {
        return userMapper.deleteUserById(id);
    }
}
