package com.krushidj.hms.modules.login.controller;

import com.krushidj.hms.modules.login.service.LoginService;
import com.krushidj.hms.modules.login.vo.LoginResponseVO;
import com.krushidj.hms.modules.login.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    LoginResponseVO register(@RequestBody LoginVO vo) {
        return loginService.login(vo);
    }
}
