package com.jonareas.techhub.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instructors")
public class Instructor implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInstructor;

    @Column(length = 80, nullable = false)
    private String fullName;

    @Column(nullable = false)
    private Boolean male;

    @Column(nullable = false)
    private String photoPath;

}
