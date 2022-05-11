package com.jonareas.techhub.controller;

import com.jonareas.techhub.dto.BaseDto;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseController<DTO extends BaseDto, ID extends Serializable> {

    ResponseEntity<List<DTO>> getAll() throws Exception;

    ResponseEntity<DTO> getById(ID id) throws Exception;

    ResponseEntity<DTO> create(DTO dto) throws Exception;

    ResponseEntity<DTO> update(DTO dto) throws Exception;

    ResponseEntity<Void> deleteById(ID id) throws Exception;



}
