package com.krushidj.hms.modules.login.vo;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginVO {
    private String userName;
    private String password;
    private String role;

}
