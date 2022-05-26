package com.mms.backend;

import com.mms.queues.AbstractQueue;
import com.mms.queues.MG1Queue;
import com.mms.queues.MMsKQueue;
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
    @PostMapping(value = "/mg1", consumes = {"*/*"})
    public QueueResponse mg1(@RequestBody MG1Queue pojo) {
        return getQueueResponse(pojo);
    }

    private QueueResponse getQueueResponse(AbstractQueue pojo) {
        QueueResponse queueResponse;
        try {
            System.out.println(pojo.print());
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
            queueResponse.setCt(pojo.calculateC());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return queueResponse;
    }
}