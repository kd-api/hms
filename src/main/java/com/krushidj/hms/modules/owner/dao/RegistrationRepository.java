package com.krushidj.hms.modules.owner.dao;

import com.krushidj.hms.modules.owner.entity.UserRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/*@Transactional(readOnly = true)*/
@Component
public interface RegistrationRepository extends JpaRepository<UserRegistrationEntity, Long> {
    @Modifying
    @Query(value = "INSERT INTO USER_INFO (FIRST_NAME,LAST_NAME,EMAIL,USER_MOBILE_NUMBER,EMERGENCY_MOBILE_NUMBER,ADHAR_NO,CREATED_AT,ACTIVE) values(:firstName,:lastName,:email,:userMobileNumber,:emergencyMobileNumber,:adharNo,:createdAt,:active)",nativeQuery = true)
    int save(@Param("firstName") String firstName,
                                @Param("lastName") String lastName,
                                @Param("email") String email,
                                @Param("userMobileNumber") String userMobileNumber,
                                @Param("emergencyMobileNumber") String emergencyMobileNumber,
                                @Param("adharNo") String adharNo,
                                @Param("createdAt") Timestamp createdAt,
                                @Param("active") boolean active
                                );
}
