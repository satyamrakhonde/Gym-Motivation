package com.gymManagement.GymMotivation.repository;

import com.gymManagement.GymMotivation.entity.Member;
import com.gymManagement.GymMotivation.entity.MemberShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberShipRepository extends JpaRepository<MemberShip, Long> {

    List<MemberShip> findByStatus(String status);
}
