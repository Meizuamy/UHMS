package org.uhms.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.uhms.user.models.User;

@Mapper
public interface UserMapper {

    User getUser(int id);

    @Insert("insert into t_user (name,address) values (#{name},#{address})")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    int insertUser(User user);

    @Delete("delete from t_user where id = #{id}")
    int deleteUserById(int id);

    @Update("update t_user set name=#{name},address=#{address} where id=#{id}")
    int updateUserById(User user);

    @Select("select * from t_user")
    List<User> findAll();

//    @Select("select * from t_user where name like '%${name}%' ")
    @Select("select * from t_user where name like concat('%',#{name},'%')")
    List<User> findUserByName(String name);

    @Select("select count(*) from t_user")
    int allCount();

    @Select("select * from t_user limit #{offset},#{limit}")
    List<User> pageUserList(int offset, int limit);
}
