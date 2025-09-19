package com.gymManagement.GymMotivation.service;

import com.gymManagement.GymMotivation.dto.MemberDto;
import com.gymManagement.GymMotivation.dto.MemberShipDto;
import com.gymManagement.GymMotivation.entity.Member;
import com.gymManagement.GymMotivation.entity.MemberShip;
import com.gymManagement.GymMotivation.repository.MemberRepository;
import com.gymManagement.GymMotivation.repository.MemberShipRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberShipRepository memberShipRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberDto createMember(MemberDto memberdto) {
        Member member = modelMapper.map(memberdto, Member.class);

//        Member savedMember = memberRepository.save(member);

        MemberShip memberShip = new MemberShip();
        memberShip.setPlanType(memberdto.getMemberShip().getPlanType());
        memberShip.setStartDate(LocalDate.now());
        memberShip.setEndDate(LocalDate.now().plusMonths(1));
        memberShip.setStatus("ACTIVE");
        member.setMemberShip(memberShip);

        memberShip.setMember(member);
        member.setMemberShip(memberShip);

        // Save only the parent
        Member savedMember = memberRepository.save(member);

//        memberShipRepository.save(memberShip);
        return modelMapper.map(savedMember, MemberDto.class);
    }

    @Override
    public MemberDto getMemberDetails(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return modelMapper.map(member, MemberDto.class);
    }

    @Override
    public List<MemberDto> getMembersDetailsWithInactiveStatus(String status) {
        logger.info(status);
        List<MemberShip> inactiveMemberships = memberShipRepository.findByStatus(status);
        logger.info("Inactive memberships: {}", inactiveMemberships.toString());
        return inactiveMemberships.stream()
                .filter(ms -> ms.getMember() != null)
                .map(memberShip -> modelMapper.map(memberShip.getMember(), MemberDto.class))
                .toList();
    }

    @Override
    public void deleteAllMembers() {
        memberRepository.deleteAll();
    }
}
