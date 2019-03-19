package com.krushidj.hms.modules.login.repository;

import com.krushidj.hms.modules.login.entity.LoginOwnerEntity;
import com.krushidj.hms.modules.login.vo.LoginResponseVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;

public interface LoginOwnerRepository extends JpaRepository<LoginOwnerEntity, Long> {
    @Query(value = "SELECT FIRST_NAME,LAST_NAME,EMAIL,OWNER_MOBILE_NUMBER,EMERGENCY_MOBILE_NUMBER FROM OWNER_INFO  WHERE EMAIL=:email AND PASSWORD=:PASSWORD)",nativeQuery = true)
    LoginResponseVO login(
             @Param("email") String email,
             @Param("password") String password
    );
}
