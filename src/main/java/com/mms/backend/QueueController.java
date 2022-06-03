package com.mms.backend;

import com.mms.queues.*;
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

//    @ResponseBody
//    @PostMapping(value = "/mms", consumes = {"*/*"})
//    public QueueResponse mms(@RequestBody MMsQueue pojo) {
//        return getQueueResponse(pojo);
//    }
//
//    @ResponseBody
//    @PostMapping(value = "/mm1", consumes = {"*/*"})
//    public QueueResponse mm1(@RequestBody MM1Queue pojo) {
//        return getQueueResponse(pojo);
//    }
//
//    @ResponseBody
//    @PostMapping(value = "/mg1", consumes = {"*/*"})
//    public QueueResponse mg1(@RequestBody MG1Queue pojo) {
//        return getQueueResponse(pojo);
//    }
//
//    @ResponseBody
//    @PostMapping(value = "/me1", consumes = {"*/*"})
//    public QueueResponse mg1(@RequestBody MEk1Queue pojo) {
//        return getQueueResponse(pojo);
//    }
//
//    @ResponseBody
//    @PostMapping(value = "/md1", consumes = {"*/*"})
//    public QueueResponse mg1(@RequestBody MD1Queue pojo) {
//        return getQueueResponse(pojo);
//    }

    private QueueResponse getQueueResponse(AbstractQueue pojo) {
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