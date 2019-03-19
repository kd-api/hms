package com.krushidj.hms.modules.login.vo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginResponseVO {
    private String firstName;
    private String lastName;
    private String email;
    private String userMobileNumber;
    private String emergencyMobileNumber;
}
