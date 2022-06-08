package com.mms.api;

import com.mms.backend.MM1Queue;
import com.mms.backend.MMsKQueue;
import com.mms.backend.MMsQueue;
import com.mms.backend.Queue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {
    @ResponseBody
    @PostMapping(value = "/mmsk", consumes = {"*/*"})
    public QueueResponse mmsk(@RequestBody MMsKQueue pojo) {
        return getQueueResponse(pojo);
    }

    @ResponseBody
    @PostMapping(value = "/mms", consumes = {"*/*"})
    public QueueResponse mms(@RequestBody MMsQueue pojo) {
        return getQueueResponse(pojo);
    }

    @ResponseBody
    @PostMapping(value = "/mm1", consumes = {"*/*"})
    public QueueResponse mm1(@RequestBody MM1Queue pojo) {
        return getQueueResponse(pojo);
    }

    private QueueResponse getQueueResponse(Queue pojo) {
        QueueResponse queueResponse;
        try {
            System.out.println(pojo.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            queueResponse = new QueueResponse();
            queueResponse.setP0(pojo.calculateP0());
            queueResponse.setPk(pojo.calculatePn(pojo.getK()));
            queueResponse.setLambdaE(pojo.calculateLambdaE());
            queueResponse.setWq(pojo.calculateWq());
            queueResponse.setW(pojo.calculateW());
            queueResponse.setLq(pojo.calculateLq());
            queueResponse.setL(pojo.calculateL());
            queueResponse.setCt(pojo.calculateCT());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return queueResponse;
    }
}