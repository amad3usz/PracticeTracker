package org.perscholas.practicetracker.exampleCoupling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Worker1 {

    public static final Logger LOG = LoggerFactory.getLogger(Worker1.class);

    public static void doWork() {

        LOG.warn("1");

        try {
            int x = 1/0;
        } catch ( Exception e) {
            LOG.error("Message: ", e);
        }


        System.out.println("Worker 1 doing work.");
    }
}

//package org.perscholas.practicetracker.exampleCoupling;
//
//public class Worker1 {
//
//    public static void doWork() {
//        System.out.println("Worker 1 doing work.");
//    }
//}