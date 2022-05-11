package com.jonareas.techhub.config;

import com.jonareas.techhub.dto.UserDto;
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

}
