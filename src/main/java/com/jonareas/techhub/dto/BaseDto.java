package com.jonareas.techhub.dto;

import lombok.*;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@MappedSuperclass
public abstract class BaseDto {

    @Min(1)
    private Long id;

}
