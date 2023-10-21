package com.abc.ecommerce.service;

import com.abc.ecommerce.entity.UserInfo;
import com.abc.ecommerce.repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserInfoService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public UserInfo getUserInfoByUserName(String userName) {
        logger.info("fetch by userName:{}", userName);
        short enabled = 1;
        return userDetailsRepository.findByUserNameAndEnabled(userName, enabled);
    }

    public List<UserInfo> getAllActiveUserInfo() {
        logger.info("fetch all active userInfo");
        return userDetailsRepository.findAllByEnabled((short) 1);
    }

    public UserInfo getUserInfoById(Integer id) {
        logger.info("fetch By User Id");
        return userDetailsRepository.findById(id);
    }

    public UserInfo addUser(UserInfo userInfo) {
        userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
        logger.info("save user");
        return userDetailsRepository.save(userInfo);
    }

    public UserInfo updateUser(Integer id, UserInfo userRecord) {
        UserInfo userInfo = userDetailsRepository.findById(id);
        userInfo.setUserName(userRecord.getUserName());
        userInfo.setPassword(userRecord.getPassword());
        userInfo.setRole(userRecord.getRole());
        userInfo.setEnabled(userRecord.getEnabled());
        logger.info("update user");
        return userDetailsRepository.save(userInfo);
    }

    public void deleteUser(Integer id) {
        logger.info("delete user");
        userDetailsRepository.deleteById(id);
    }

    public UserInfo updatePassword(Integer id, UserInfo userRecord) {
        UserInfo userInfo = userDetailsRepository.findById(id);
        userInfo.setPassword(userRecord.getPassword());
        logger.info("update password");
        return userDetailsRepository.save(userInfo);
    }

}