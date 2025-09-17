package com.trial.demo.Repository;

import com.trial.demo.Model.Demo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends MongoRepository<Demo,Integer> {
}
