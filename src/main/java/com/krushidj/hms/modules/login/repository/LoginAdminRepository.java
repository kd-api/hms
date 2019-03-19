package com.krushidj.hms.modules.login.repository;

import com.krushidj.hms.modules.login.entity.LoginAdminEntity;
import com.krushidj.hms.modules.login.vo.LoginResponseVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginAdminRepository extends JpaRepository<LoginAdminEntity, Long> {
    @Query(value = "SELECT FIRST_NAME,LAST_NAME,EMAIL,ADMIN_MOBILE_NUMBER,EMERGENCY_MOBILE_NUMBER FROM OWNER_INFO  WHERE EMAIL=:email AND PASSWORD=:PASSWORD)",nativeQuery = true)
    LoginResponseVO login(
            @Param("email") String email,
            @Param("password") String password
    );
}
