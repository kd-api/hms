package com.krushidj.hms.modules.login.service;

import com.krushidj.hms.modules.login.vo.LoginResponseVO;
import com.krushidj.hms.modules.login.vo.LoginVO;

public interface LoginService {
    LoginResponseVO login(LoginVO vo);
}
