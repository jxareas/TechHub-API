package com.jonareas.techhub.controller;

import com.jonareas.techhub.dto.UserDto;
import com.jonareas.techhub.exceptions.ModelNotFoundException;
import com.jonareas.techhub.model.User;
import com.jonareas.techhub.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController implements BaseController<UserDto, Long> {

    private final UserService service;
    private final ModelMapper mapper;

    @Autowired
    UserController(UserService service, @Qualifier("userMapper") ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() throws Exception {
        List<UserDto> users = service.getAll()
                .stream()
                .map(user ->
                        mapper.map(user, UserDto.class))
                .collect(toList());

        return ResponseEntity.ok(users);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id) throws Exception {
        User user = service.getById(id);
        if(user == null) {
            throw new ModelNotFoundException(ModelNotFoundException.identifierNotFoundMessage(id));
        }
        UserDto instructorDto = mapper.map(user, UserDto.class);
        return ResponseEntity.ok(instructorDto);
    }

    @Override
    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto dto) throws Exception {
    User user = service.create(mapper.map(dto, User.class));
    UserDto instructorDto = mapper.map(user, UserDto.class);
    return new ResponseEntity<>(instructorDto, HttpStatus.CREATED);
    }

    @Override
    @PutMapping
    public ResponseEntity<UserDto> update(@Valid @RequestBody UserDto dto) throws Exception {
        User user = service.getById(dto.getId());
        if(user == null) {
            throw new ModelNotFoundException(ModelNotFoundException.identifierNotFoundMessage(dto.getId()));
        }
        User newInstructor = service.update(mapper.map(dto, User.class));
        UserDto instructorDto = mapper.map(newInstructor, UserDto.class);
        return new ResponseEntity<>(instructorDto, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) throws Exception {
        User user = service.getById(id);
        if(user == null) {
            throw new ModelNotFoundException(ModelNotFoundException.identifierNotFoundMessage(id));
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
