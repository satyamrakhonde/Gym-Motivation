package com.gymManagement.GymMotivation.service;

import com.gymManagement.GymMotivation.dto.MemberDto;

import java.util.List;

public interface MemberService {
    MemberDto createMember(MemberDto memberdto);

    MemberDto getMemberDetails(Long id);

    List<MemberDto> getMembersDetailsWithInactiveStatus(String status);

    void deleteAllMembers();
}
