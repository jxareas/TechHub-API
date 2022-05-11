package com.jonareas.techhub.repository;

import com.jonareas.techhub.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends BaseRepository<Topic, Long> {

}
