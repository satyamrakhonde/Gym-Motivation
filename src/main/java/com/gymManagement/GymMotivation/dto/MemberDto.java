package com.gymManagement.GymMotivation.dto;

import com.gymManagement.GymMotivation.entity.MemberShip;
import lombok.Data;

@Data
public class MemberDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private MemberShip memberShip;
}
