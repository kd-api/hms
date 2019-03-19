package com.krushidj.hms.modules.owner.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The entity holds the data from USER_INFO
 */
@Entity
@Table(name = "USER_INFO")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserRegistrationEntity implements Serializable {

    private static final long serialVersionUID = 5986557982352842324L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USER_MOBILE_NUMBER")
    private String userMobileNumber;


    @Column(name = "EMERGENCY_MOBILE_NUMBER")
    private String emergencyMobileNumber;

    @Column(name = "ADHAR_NO")
    private String adharNo;

    @Column(name = "CREATED_AT")
    private Timestamp createdAt;

    @Column(name = "ACTIVE")
    private boolean active;
}
