package com.jonareas.techhub.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course implements BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;

    private String name;

    private String description;

    private String imageUrl;

    private String imageContentDesc;

    private Integer steps;

    private Integer step;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", nullable = false)
    private Topic topic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_instructor")
    private Instructor instructor;

}
