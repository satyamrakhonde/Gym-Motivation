package com.gymManagement.GymMotivation.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "memberships")
public class MemberShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String planType; //MONTHLY, QUATERLY, YEARLY

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToOne
    @JoinColumn(name="member_id")
    private Member member; //Owning side
}
