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
public class Course implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String imageUrl;

    @Column(length = 150, nullable = false)
    private String imageContentDesc;

    @Column(nullable = false)
    private Integer steps;

    @Column(nullable = false)
    private Integer step;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", nullable = false)
    private Topic topic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_instructor")
    private Instructor instructor;

}
