package com.gymManagement.GymMotivation.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MemberShipDto {

    private Long id;
    private String planType; //MONTHLY, QUATERLY, YEARLY
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; //ACTIVE, INACTIVE
    private MemberDto member;
}
