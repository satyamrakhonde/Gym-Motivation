package com.gymManagement.GymMotivation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "memberships")
public class MemberShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String planType; //MONTHLY, QUATERLY, YEARLY

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

    @OneToOne
    @JoinColumn(name="member_id")
    @JsonIgnore
    private Member member; //Owning side
}
