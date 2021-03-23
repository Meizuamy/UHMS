package org.uhms.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.uhms.user.mapper.UserMapper;
import org.uhms.user.models.User;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void test_select_user_by_user_id(){
        User user = userMapper.getUser(1L);
        Assert.assertNotNull(user);
        System.out.println(user);
    }

    @Test
    public void contextLoad(){

//        User user = new User();
//        user.setName("张子军");
//        user.setAddress("河南省周口市");
//        userMapper.insertUser(user);

        System.out.println(userMapper.allCount());
        List<User> users = userMapper.findAll();
        for (User user : users){
            System.out.println(user);
        }

        users = userMapper.findUserByName("张");
        for (User user : users){
            System.out.println(user);
        }
        users = userMapper.findUserByName("赵");
        for (User user : users){
            System.out.println(user);
        }

//        System.out.println(userMapper.getUser(1L));
    }

}
