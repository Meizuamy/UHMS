package org.uhms.user.mapper;

import org.apache.ibatis.annotations.*;
import org.uhms.user.models.User;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Mapper
public interface UserMapper {

    @Select("select * from t_user where id=#{id}")
    User getUser(Long id);

    @Insert("insert into t_user (name,address) values (#{name},#{address})")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    Integer insertUser(User user);

    @Delete("delete from t_user where id = #{id}")
    Integer deleteUserById(Long id);

    @Update("update t_user set name=#{name},address=#{address} where id=#{id}")
    Integer updateUserById(User user);

    @Select("select * from t_user")
    List<User> findAll();

//    @Select("select * from t_user where name like '%${name}%' ")
    @Select("select * from t_user where name like concat('%',#{name},'%')")
    List<User> findUserByName(String name);

    @Select("select count(*) from t_user")
    Long allCount();

    @Select("select * from t_user limit #{offset},#{limit}")
    List<User> pageUserList(int offset, int limit);
}
