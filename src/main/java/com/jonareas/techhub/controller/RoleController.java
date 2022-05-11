package com.jonareas.techhub.controller;

import com.jonareas.techhub.dto.RoleDto;
import com.jonareas.techhub.exceptions.ModelNotFoundException;
import com.jonareas.techhub.model.Role;
import com.jonareas.techhub.service.RoleService;
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
@RequestMapping("/roles")
public class RoleController implements BaseController<RoleDto, Long> {

    private final RoleService service;
    private final ModelMapper mapper;

    @Autowired
    RoleController(RoleService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RoleDto>> getAll() throws Exception {
        List<RoleDto> roles = service.getAll()
                .stream()
                .map(role ->
                        mapper.map(role, RoleDto.class))
                .collect(toList());

        return ResponseEntity.ok(roles);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getById(@PathVariable("id") Long id) throws Exception {
        Role role = service.getById(id);
        if(role == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        RoleDto instructorDto = mapper.map(role, RoleDto.class);
        return ResponseEntity.ok(instructorDto);
    }

    @Override
    @PostMapping
    public ResponseEntity<RoleDto> create(@Valid @RequestBody RoleDto dto) throws Exception {
    Role role = service.create(mapper.map(dto, Role.class));
    RoleDto instructorDto = mapper.map(role, RoleDto.class);
    return new ResponseEntity<>(instructorDto, HttpStatus.CREATED);
    }

    @Override
    @PutMapping
    public ResponseEntity<RoleDto> update(@Valid @RequestBody RoleDto dto) throws Exception {
        Role role = service.getById(dto.getId());
        if(role == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getId());
        }
        Role newInstructor = service.update(mapper.map(dto, Role.class));
        RoleDto instructorDto = mapper.map(newInstructor, RoleDto.class);
        return new ResponseEntity<>(instructorDto, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {
        Role role = service.getById(id);
        if(role == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
