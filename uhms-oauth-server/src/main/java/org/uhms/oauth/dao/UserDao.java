package org.uhms.oauth.dao;

import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.uhms.oauth.model.TbUser;
import org.uhms.oauth.model.User;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM tb_user WHERE username = #{username}")
    TbUser findByUserName(@Param("username") String username);
}
