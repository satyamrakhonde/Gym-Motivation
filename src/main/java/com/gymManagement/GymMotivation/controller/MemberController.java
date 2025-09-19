package com.gymManagement.GymMotivation.controller;

import com.gymManagement.GymMotivation.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {

        @Autowired
        private MemberService memberService;

        
}
