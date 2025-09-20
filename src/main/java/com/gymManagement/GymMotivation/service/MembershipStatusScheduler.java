package com.gymManagement.GymMotivation.service;

import com.gymManagement.GymMotivation.entity.MemberShip;
import com.gymManagement.GymMotivation.repository.MemberShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MembershipStatusScheduler {

    @Autowired
    MemberShipRepository memberShipRepository;

    //Run everyday at 00:00 (midnight) //test it by making it every 30 seconds -- cron = "*/30 * * * * ?"
    @Scheduled(cron = "0 0 0 * * ?")
    public void updateExpiredMemberships() {

        LocalDate today = LocalDate.now();

        List<MemberShip> activeMemberships = memberShipRepository.findByStatus("ACTIVE");

        for(MemberShip memberShip : activeMemberships) {
            if(memberShip.getEndDate() != null && memberShip.getEndDate().isBefore(today)) {
                memberShip.setStatus("INACTIVE");
            }
        }

        memberShipRepository.saveAll(activeMemberships);

    }
}
