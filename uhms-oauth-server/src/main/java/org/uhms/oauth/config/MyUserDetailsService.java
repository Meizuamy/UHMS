package org.uhms.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.uhms.oauth.dao.TbPermissionDao;
import org.uhms.oauth.dao.UserDao;
import org.uhms.oauth.model.TbPermission;
import org.uhms.oauth.model.TbUser;
import org.uhms.oauth.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TbPermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser user = userDao.findByUserName(username);
        // 用户不存在将抛出异常
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        // 将数据库形式的roles解析为UserDetails的权限集
        // AuthorityUtils。commaSeparatedStringToAuthorityList() 是 spring security 提供的，该方法用于将都好隔开的权限集
        // 字符串切割成可用的权限列表
//        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));

        List<TbPermission> tbPermissions = permissionDao.selectByUserId(user.getId());
        user.setAuthorities(generateAuthorities(tbPermissions));

        return user;

    }

    private List<GrantedAuthority> generateAuthorities(List<TbPermission> tbPermissions){
        List<GrantedAuthority> authorities = new ArrayList<>();

        tbPermissions.forEach(tbPermission -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
            authorities.add(grantedAuthority);
        });
        return authorities;
    }


    private List<GrantedAuthority> generateAuthorities(String roles){
        List<GrantedAuthority> authorities = new ArrayList<>();
        String[] roleArray = roles.split(";");
        if(roles != null && !"".equals(roles)){
            for(String role : roleArray){
                authorities.add(new SimpleGrantedAuthority(role));
            }
        }
        return authorities;
    }
}
