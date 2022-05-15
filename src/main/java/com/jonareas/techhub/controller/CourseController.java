package com.jonareas.techhub.controller;

import com.jonareas.techhub.dto.CourseCreateDto;
import com.jonareas.techhub.dto.CourseDto;
import com.jonareas.techhub.exceptions.ModelNotFoundException;
import com.jonareas.techhub.model.Course;
import com.jonareas.techhub.service.CourseService;
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
@RequestMapping("/courses")
public class CourseController  {

    private final CourseService service;
    private final ModelMapper mapper;

    @Autowired
    CourseController(CourseService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    
    @GetMapping
    public ResponseEntity<List<CourseDto>> getAll() throws Exception {
        List<CourseDto> courses = service.getAll()
                .stream()
                .map(course ->
                        mapper.map(course, CourseDto.class))
                .collect(toList());

        return ResponseEntity.ok(courses);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getById(@PathVariable("id") Long id) throws Exception {
        Course course = service.getById(id);
        if(course == null) {
            throw new ModelNotFoundException(ModelNotFoundException.identifierNotFoundMessage(id));
        }
        CourseDto courseDto = mapper.map(course, CourseDto.class);
        return ResponseEntity.ok(courseDto);
    }


    @PostMapping
    public ResponseEntity<CourseCreateDto> create(@Valid @RequestBody CourseCreateDto dto) throws Exception {
    Course course = service.create(mapper.map(dto, Course.class));
    CourseCreateDto courseDto = mapper.map(course, CourseCreateDto.class);
    return new ResponseEntity<>(courseDto, HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<CourseCreateDto>> create(@RequestBody List<CourseCreateDto> dtos) throws Exception {
        for(CourseCreateDto dto : dtos) {
            create(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    
    @PutMapping
    public ResponseEntity<CourseDto> update(@Valid @RequestBody CourseDto dto) throws Exception {
        Course course = service.getById(dto.getId());
        if(course == null) {
            throw new ModelNotFoundException(ModelNotFoundException.identifierNotFoundMessage(dto.getId()));
        }
        Course newCourse = service.update(mapper.map(dto, Course.class));
        CourseDto courseDto = mapper.map(newCourse, CourseDto.class);
        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {
        Course course = service.getById(id);
        if(course == null) {
            throw new ModelNotFoundException(ModelNotFoundException.identifierNotFoundMessage(id));
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
