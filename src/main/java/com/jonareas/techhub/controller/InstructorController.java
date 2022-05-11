package com.jonareas.techhub.controller;

import com.jonareas.techhub.dto.InstructorDto;
import com.jonareas.techhub.exceptions.ModelNotFoundException;
import com.jonareas.techhub.model.Instructor;
import com.jonareas.techhub.service.InstructorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/instructors")
public class InstructorController implements BaseController<InstructorDto, Long> {

    private final InstructorService service;
    private final ModelMapper mapper;

    @Autowired
    InstructorController(InstructorService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<InstructorDto>> getAll() throws Exception {
        List<InstructorDto> instructors = service.getAll()
                .stream()
                .map(instructor ->
                        mapper.map(instructor, InstructorDto.class))
                .collect(toList());

        return ResponseEntity.ok(instructors);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<InstructorDto> getById(@PathVariable("id") Long id) throws Exception {
        Instructor instructor = service.getById(id);
        if(instructor == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        InstructorDto instructorDto = mapper.map(instructor, InstructorDto.class);
        return ResponseEntity.ok(instructorDto);
    }

    @Override
    @PostMapping
    public ResponseEntity<InstructorDto> create(@Valid @RequestBody InstructorDto dto) throws Exception {
    Instructor instructor = service.create(mapper.map(dto, Instructor.class));
    InstructorDto instructorDto = mapper.map(instructor, InstructorDto.class);
    return new ResponseEntity<>(instructorDto, HttpStatus.CREATED);
    }

    @Override
    @PutMapping
    public ResponseEntity<InstructorDto> update(@Valid @RequestBody InstructorDto dto) throws Exception {
        Instructor instructor = service.getById(dto.getId());
        if(instructor == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getId());
        }
        Instructor newInstructor = service.update(mapper.map(dto, Instructor.class));
        InstructorDto instructorDto = mapper.map(newInstructor, InstructorDto.class);
        return new ResponseEntity<>(instructorDto, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {
        Instructor instructor = service.getById(id);
        if(instructor == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
