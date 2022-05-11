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

    private String name;

    private Integer totalCourses;

    private String imageUrl;


}
