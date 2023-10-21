package com.abc.ecommerce.repository;
import java.util.List;

import javax.transaction.Transactional;

import com.abc.ecommerce.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserDetailsRepository extends CrudRepository<UserInfo, String> {
    UserInfo findByUserNameAndEnabled(String userName, short enabled);

    List<UserInfo> findAllByEnabled(short enabled);

    UserInfo findById(Integer id);

    void deleteById(Integer id);
}