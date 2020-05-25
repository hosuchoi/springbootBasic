package com.lake.smartway.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserInfoRepository extends JpaRepository<UserInfoDVO, Long> {

    Optional<UserInfoDVO> findByUsername(String username);

    //native query , JPQL query로 커스텀한 쿼리 가능
    @Query(nativeQuery = true, value = "select * from user_info where username = '{0}'")
    Optional<UserInfoDVO> findUserName(String username);
}
