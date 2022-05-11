package com.jonareas.techhub.service.impl;

import com.jonareas.techhub.model.Course;
import com.jonareas.techhub.repository.CourseRepository;
import com.jonareas.techhub.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends BaseServiceImpl<Course, Long> implements CourseService {

    private CourseRepository repository;

    @Autowired
    CourseServiceImpl(CourseRepository repository) {
        super(repository);
    }

}
