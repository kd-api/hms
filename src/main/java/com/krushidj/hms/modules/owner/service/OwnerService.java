package com.krushidj.hms.modules.owner.service;

import com.krushidj.hms.modules.owner.entity.UserRegistrationEntity;
import com.krushidj.hms.modules.owner.vo.UserRegistrationVO;

public interface OwnerService {
    int register(UserRegistrationVO vo);
}
