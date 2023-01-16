package com.frcsprep.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name="FRCS_MEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FrcsMem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ROLES", nullable = false)
    private String roles;

    @Column(name = "IS_ACTIVE", nullable = false)
    private long isActive;
}
