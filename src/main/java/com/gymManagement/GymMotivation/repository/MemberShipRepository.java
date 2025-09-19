package com.gymManagement.GymMotivation.repository;

import com.gymManagement.GymMotivation.entity.MemberShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberShipRepository extends JpaRepository<MemberShip, Long> {

}
