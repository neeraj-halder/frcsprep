package com.frcsprep.repo;

import com.frcsprep.entity.FrcsMem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrcsMemRepo extends JpaRepository<FrcsMem,Integer> {
    public FrcsMem findByUserName(String userName);
}
