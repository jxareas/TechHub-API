package com.jonareas.techhub.controller;

import com.jonareas.techhub.dto.TopicDto;
import com.jonareas.techhub.exceptions.ModelNotFoundException;
import com.jonareas.techhub.model.Topic;
import com.jonareas.techhub.service.TopicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/topics")
public class TopicController implements BaseController<TopicDto ,Long> {

    private final TopicService service;
    private final ModelMapper mapper;

    @Autowired
    TopicController(TopicService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<TopicDto>> getAll() throws Exception {
        List<TopicDto> topics = service.getAll()
                .stream()
                .map(topic ->
                        mapper.map(topic, TopicDto.class))
                .collect(toList());

        return ResponseEntity.ok(topics);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TopicDto> getById(@PathVariable("id") Long id) throws Exception {
        Topic topic = service.getById(id);
        if(topic == null) {
            throw new ModelNotFoundException(ModelNotFoundException.identifierNotFoundMessage(id));
        }
        TopicDto topicDto = mapper.map(topic, TopicDto.class);
        return ResponseEntity.ok(topicDto);
    }

    @Override
    @PostMapping
    public ResponseEntity<TopicDto> create(@Valid @RequestBody TopicDto dto) throws Exception {
        Topic topic = service.create(mapper.map(dto, Topic.class));
        TopicDto topicDto = mapper.map(topic, TopicDto.class);
        return new ResponseEntity<>(topicDto, HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<TopicDto>> create(@RequestBody List<TopicDto> dtos) throws Exception {
        for(TopicDto dto : dtos) {
            create(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @Override
    @PutMapping
    public ResponseEntity<TopicDto> update(@Valid @RequestBody TopicDto dto) throws Exception {
        Topic topic = service.getById(dto.getId());
        if(topic == null) {
            throw new ModelNotFoundException(ModelNotFoundException.identifierNotFoundMessage(dto.getId()));
        }
        Topic newTopic = service.update(mapper.map(dto, Topic.class));
        TopicDto topicDto = mapper.map(newTopic, TopicDto.class);
        return new ResponseEntity<>(topicDto, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {
        Topic topic = service.getById(id);
        if(topic == null) {
            throw new ModelNotFoundException(ModelNotFoundException.identifierNotFoundMessage(id));
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
