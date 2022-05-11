package com.jonareas.techhub.service.impl;

import com.jonareas.techhub.model.Topic;
import com.jonareas.techhub.repository.BaseRepository;
import com.jonareas.techhub.repository.TopicRepository;
import com.jonareas.techhub.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl extends BaseServiceImpl<Topic, Long> implements TopicService {

    private TopicRepository repository;

    @Autowired
    TopicServiceImpl(TopicRepository repository) {
        super(repository);
    }
}
