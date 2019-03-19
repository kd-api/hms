package com.krushidj.hms.modules.owner.controller;

import com.krushidj.hms.modules.owner.entity.UserRegistrationEntity;
import com.krushidj.hms.modules.owner.service.OwnerService;
import com.krushidj.hms.modules.owner.vo.UserRegistrationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/api")

public class OwnerController {

    @Resource
    public OwnerService ownerService;

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public @ResponseBody
    int register( @RequestBody UserRegistrationVO vo) {
        return ownerService.register(vo);
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody
    boolean test() {
        System.out.println("test");
        return true;
    }
}
