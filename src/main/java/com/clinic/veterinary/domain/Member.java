package com.clinic.veterinary.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    //@Column(nullable = false)
    private Role role;

    @OneToOne
    private Doctor doctor;

    public Member(String loginId, String username, String password, String email, Role role, Doctor doctor) {
        this.loginId = loginId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.doctor = doctor;
    }
}
