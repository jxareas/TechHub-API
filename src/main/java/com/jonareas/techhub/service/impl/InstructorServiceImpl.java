package com.jonareas.techhub.service.impl;

import com.jonareas.techhub.model.Instructor;
import com.jonareas.techhub.repository.InstructorRepository;
import com.jonareas.techhub.repository.TopicRepository;
import com.jonareas.techhub.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl extends BaseServiceImpl<Instructor, Long> implements InstructorService {

    private InstructorRepository repository;

    @Autowired
    InstructorServiceImpl(InstructorRepository repository) {
        super(repository);
    }

}
