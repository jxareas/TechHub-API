package com.jonareas.techhub.repository;

import com.jonareas.techhub.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends BaseRepository<Instructor, Long> {

}
