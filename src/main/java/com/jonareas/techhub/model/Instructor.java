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

    private String fullName;

    private Boolean isMale;

    private String photoUrl;

}
