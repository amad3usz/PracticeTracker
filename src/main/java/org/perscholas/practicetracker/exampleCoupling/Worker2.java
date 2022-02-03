package org.perscholas.practicetracker.exampleCoupling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Worker2 {
    public static final Logger LOG = LoggerFactory.getLogger(Worker2.class);
    public static void doWork() {
        LOG.debug("2");
        System.out.println("Worker 2 doing work.");
    }
}

//package org.perscholas.practicetracker.exampleCoupling;
//
//public class Worker2 {
//    public static void doWork() {
//        System.out.println("Worker 2 doing work.");
//    }
//}
