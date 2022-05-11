package com.jonareas.techhub.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @ManyToOne // FK
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 60, nullable = false)
    private String password;

    private boolean enabled;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Course> courses = new ArrayList<>();

}