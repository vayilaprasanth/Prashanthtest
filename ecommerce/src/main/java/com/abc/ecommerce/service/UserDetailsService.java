package com.abc.ecommerce.service;

import com.abc.ecommerce.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserInfoService userInfoDAO;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        logger.info("fetch by userName:{}", userName);
        UserInfo userInfo = userInfoDAO.getUserInfoByUserName(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
        return new User(userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(authority));
    }
}
