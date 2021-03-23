package org.uhms.oauth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.uhms.oauth.model.TbPermission;

import java.util.List;

@Mapper
public interface TbPermissionDao {

    @Select("select p.* from tb_user as u left join tb_user_role as ur on u.id = ur.user_id left join tb_role as r on r.id = ur.role_id left join tb_role_permission as rp on r.id = rp.role_id left join tb_permission as p on p.id = rp.permission_id where u.id = #{id}")
    List<TbPermission> selectByUserId(@Param("id")Long id);
}
