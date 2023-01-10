package com.frcsprep.repo;

import com.frcsprep.entity.Topics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsRepo extends CrudRepository<Topics,Long> {
}
