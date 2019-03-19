package com.krushidj.hms.modules.login.service.impl;

import com.krushidj.hms.helpers.AppConstant;
import com.krushidj.hms.modules.login.entity.LoginAdminEntity;
import com.krushidj.hms.modules.login.entity.LoginOwnerEntity;
import com.krushidj.hms.modules.login.entity.LoginUserEntity;
import com.krushidj.hms.modules.login.repository.LoginAdminRepository;
import com.krushidj.hms.modules.login.repository.LoginOwnerRepository;
import com.krushidj.hms.modules.login.repository.LoginUserRepository;
import com.krushidj.hms.modules.login.service.LoginService;
import com.krushidj.hms.modules.login.vo.LoginResponseVO;
import com.krushidj.hms.modules.login.vo.LoginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(readOnly = true)
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginAdminRepository loginAdminRepository;
    @Resource
    private LoginOwnerRepository loginOwnerRepository;
    @Resource
    private LoginUserRepository loginUserRepository;

    @Override
    public LoginResponseVO login(LoginVO vo) {
        if (vo.getRole() == null) {
            throw new com.hms.modules.exception.BadRequestException("role not specified");
        }
        LoginResponseVO loginResponseVO = new LoginResponseVO();
        switch (vo.getRole()) {
            case AppConstant.admin:
                LoginAdminEntity loginAdminEntity = new LoginAdminEntity();
                BeanUtils.copyProperties(vo, loginAdminEntity);
                loginResponseVO = loginAdminRepository.login(
                        loginAdminEntity.getEmail(),
                        loginAdminEntity.getPassword()
                );
                break;

            case AppConstant.user:
                LoginUserEntity loginUserEntity = new LoginUserEntity();
                BeanUtils.copyProperties(vo, loginUserEntity);
                loginResponseVO = loginUserRepository.login(
                        loginUserEntity.getEmail(),
                        loginUserEntity.getPassword()
                );
                break;
            case AppConstant.owner:
                LoginOwnerEntity loginOwnerEntity = new LoginOwnerEntity();
                BeanUtils.copyProperties(vo, loginOwnerEntity);
                loginResponseVO = loginOwnerRepository.login(
                        loginOwnerEntity.getEmail(),
                        loginOwnerEntity.getPassword()
                );
                break;
            default:
                throw new com.hms.modules.exception.BadRequestException("Role not matched");
        }
        return loginResponseVO;

    }
}
