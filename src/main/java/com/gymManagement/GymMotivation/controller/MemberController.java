package com.gymManagement.GymMotivation.controller;

import com.gymManagement.GymMotivation.dto.MemberDto;
import com.gymManagement.GymMotivation.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberdto) {
        return new ResponseEntity<>(memberService.createMember(memberdto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public MemberDto getMember(@PathVariable Long id) {
        return memberService.getMemberDetails(id);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<MemberDto>> getAllMembers(@PathVariable String status) {
        System.out.println(status);
        return new ResponseEntity<>(memberService.getMembersDetailsWithInactiveStatus(status), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll() {
        return ResponseEntity.ok("All members Deleted Successfully");
    }
}
