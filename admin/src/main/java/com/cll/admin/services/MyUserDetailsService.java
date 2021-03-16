package com.cll.admin.services;

import com.cll.mbg.mapper.TUserMapper;
import com.cll.mbg.model.TUser;
import com.cll.mbg.model.TUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;
import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    TUserMapper tUserMapper;
    @Override
    public UserDetails loadUserByUsername(String tel) throws UsernameNotFoundException {
        TUserExample example = new TUserExample();
        example.createCriteria().andTelEqualTo(tel);
        List<TUser> tUsers = tUserMapper.selectByExample(example);
        if (tUsers.size() == 0){throw new UsernameNotFoundException("用户未找到");}
        TUser tUser = tUsers.get(0);
        return new User(tel,tUser.getPass(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
