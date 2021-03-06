package com.krushidj.hms.modules.login.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The entity holds the data from USER_INFO
 */
@Entity
@Table(name = "ADMIN_INFO")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginAdminEntity {
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
}

