package com.krushidj.hms.modules.owner.service;

import com.krushidj.hms.modules.owner.dao.RegistrationRepository;
import com.krushidj.hms.modules.owner.entity.UserRegistrationEntity;
import com.krushidj.hms.modules.owner.vo.UserRegistrationVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;


@Service
@Transactional(readOnly = true)
public class OwnerSeviceImpl implements OwnerService {

    @Resource
    RegistrationRepository registrationRepository;

    {
        System.out.println(registrationRepository);
    }

    @Override
    @Transactional
    public int register(UserRegistrationVO vo) {
        System.out.println(vo);
        UserRegistrationEntity entity = new UserRegistrationEntity();
        BeanUtils.copyProperties(vo,entity);
        /*entity.setFirstName(vo.getFirstName());
        entity.setLastName(vo.getLastName());
        entity.setAdharNo(vo.getAdharNo());*/
        entity.setActive(true);
        /*entity.setEmail(vo.getEmail());
        entity.setUserMobileNumber(vo.getUserMobileNumber());
        entity.setEmergencyMobileNumber(vo.getEmergencyMobileNumber());*/
        entity.setCreatedAt(new Timestamp(new Date().getTime()));
        System.out.println(entity);
        return registrationRepository.save(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getUserMobileNumber(),
                entity.getEmergencyMobileNumber(),
                entity.getAdharNo(),
                entity.getCreatedAt(),
                entity.isActive()
                );
    }
}
