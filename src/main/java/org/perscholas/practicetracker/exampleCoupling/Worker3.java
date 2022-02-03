package org.perscholas.practicetracker.exampleCoupling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Worker3 {
    public static final Logger LOG = LoggerFactory.getLogger(Worker3.class);
    public static void doWork() {
        LOG.info("3");
        System.out.println("Worker 3 doing work." );
    }
}

//package org.perscholas.practicetracker.exampleCoupling;
//
//public class Worker3 {
//    public static void doWork() {
//        System.out.println("Worker 3 doing work.");
//    }
//}
