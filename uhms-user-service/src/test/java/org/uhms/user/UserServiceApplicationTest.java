package org.uhms.user;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.uhms.user.mapper.UserMapper;
import org.uhms.user.models.User;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceApplicationTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceApplicationTest.class);

    @Resource
    UserMapper userMapper;

    @Test
    public void test_select_user_by_user_id() {
        User user = userMapper.getUser(1L);
        assertNotNull(user);
        log.debug("UserInfo is : {}", user);
    }

    @Test
    public void contextLoad() {

        // 插入用户
        User user = new User();
        user.setName("张子军");
        user.setAddress("河南省周口市");
        userMapper.insertUser(user);

        log.debug("Search User AllCount: {}", userMapper.allCount());
        List<User> users = userMapper.findAll();
        for (User u : users) {
            log.info("User: {}", u);
        }

        users = userMapper.findUserByName("张");
        for (User u : users) {
            log.info("Find User By Name: ", u);
        }

        log.info("Find User By Id: {}", userMapper.getUser(1L));
    }

}
