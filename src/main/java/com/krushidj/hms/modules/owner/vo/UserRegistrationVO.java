package com.krushidj.hms.modules.owner.vo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserRegistrationVO {
    private String firstName;
    private String lastName;
    private String email;
    private String userMobileNumber;
    private String emergencyMobileNumber;
    private String adharNo;


}
