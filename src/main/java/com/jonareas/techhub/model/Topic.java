package com.jonareas.techhub.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "topics")
public class Topic implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTopic;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer totalCourses;

    @Column(nullable = false)
    private String imageUrl;


}
