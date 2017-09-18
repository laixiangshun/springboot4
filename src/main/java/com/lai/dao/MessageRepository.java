package com.lai.dao;

import com.lai.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lailai on 2017/9/18.
 */
@Repository
public interface MessageRepository extends MongoRepository<Message,Long> {
    Message findByName(String name);
}
