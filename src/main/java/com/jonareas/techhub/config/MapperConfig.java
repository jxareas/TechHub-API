package com.jonareas.techhub.config;

import com.jonareas.techhub.dto.CourseCreateDto;
import com.jonareas.techhub.dto.UserDto;
import com.jonareas.techhub.model.Course;
import com.jonareas.techhub.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfig {

    @Bean(name = "defaultMapper")
    @Primary
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    @Bean(name = "userMapper")
    public ModelMapper userMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<UserDto, User> typeMap = mapper.createTypeMap(UserDto.class, User.class);
        typeMap.addMapping(UserDto::getIdRole, (dest, v)-> dest.getRole().setIdRole((Long) v));
        return mapper;
    }

    @Bean(name = "courseMapper")
    public ModelMapper courseMapper() {
        ModelMapper mapper = new ModelMapper();

        TypeMap<CourseCreateDto, Course> typeMap = mapper.createTypeMap(CourseCreateDto.class, Course.class);
        typeMap.addMapping(CourseCreateDto::getInstructorId, (dest, v) -> dest.getInstructor().setIdInstructor((Long) v));
        typeMap.addMapping(CourseCreateDto::getTopicId, (dest, v) -> dest.getTopic().setIdTopic((Long) v));
        return mapper;
    }

}
