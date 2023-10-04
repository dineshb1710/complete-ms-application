package com.dinesh.appz.order.utils;

import com.dinesh.appz.order.dto.UserDto;
import com.dinesh.appz.order.entity.OrderSequence;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderServiceUtils {

    private final MongoOperations mongoOperations;
    private final RestTemplate restTemplate;

    public int getNextOrderId() {
        OrderSequence orderSequence = mongoOperations.findAndModify(
                query(where("_id").is("order_sequence")),
                new Update().inc("seqNo", 1),
                options().returnNew(true).upsert(true), OrderSequence.class);

        return orderSequence.getSeqNo();
    }

    public UserDto fetchUserInformationById(int userId) {
        return restTemplate.getForObject("http://USER-INFO-SERVICE/api/v1/user/fetch/" + userId, UserDto.class);
    }
}
