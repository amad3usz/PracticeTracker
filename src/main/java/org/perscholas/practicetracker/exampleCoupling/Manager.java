package org.perscholas.practicetracker.exampleCoupling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component for spring to recognize classes to create and put in the context
//Spring creates everything in the first pass
@Component //when spring starts up it looks for certain classes that have annotations and instantiates the annotation and puts it in the context (bucket) which can be asked for later out of the same bucket
public class Manager {

    // first spring creates context where it will put all objects that is it going to create
    // the context is like a bucket where it puts objects that is creates and we can ask for the later with autowire
    // spring makes 3 passes when it starts up
    // first pass is called a component scan, which finds all spring classes with an annotation on them such as @Controller, @Component, @Repository and creates instance of this class; essentially creates a new object of the annotated class
    // second pass is when it does all @Autowired, which is done in the second pass because all objects need to be created before they can be autowired, prevents problems like circular dependencies and not creating something that isn't needed as well as other problems (like autopopulating userDao in registration)
    // WARNING: in Spring you can not use constructors to intitialize the class if it is using an autowired variable, because on pass one when it is creating the instances of all classes, it has not yet autowired every variable
    // the third pass that spring will make will run all @PostConstruct methods
    @Autowired
    private Worker1 worker1;

    @Autowired
    private Worker2 worker2;


//    @Autowired
//    private Worker3 worker3;

    private Worker3 worker3;
    @Autowired
    public void setFooFormatter(Worker3 w3) {
        this.worker3 = w3;
    }

    //dont even need this constructor
    public Manager() { //instead of passing classes to constructor
        System.out.println("I am in the manager constructor");
//        this executed before autowired
//        these lines will fail due to spring has not yet autowired the variables
//        it is not good practice to use the constructor with spring components for this reason
//        worker1.doWork();
//        worker2.doWork();
//        worker3.doWork();
    }

    @PostConstruct
    public void init() {
        worker1.doWork();
        worker2.doWork();
        worker3.doWork();
    }

}

//Tight coupling = bad coding
//package org.perscholas.practicetracker.exampleCoupling;
//
//public class Manager {
//
//    private Worker1 worker1;
//    private Worker2 worker2;
//    private Worker3 worker3;
//
//    public Manager(Worker1 worker1, Worker2 worker2, Worker3 worker3) {
//        this.worker1 = worker1;
//        this.worker2 = worker2;
//        this.worker3 = worker3;
//
//        worker1.doWork();
//        worker2.doWork();
//        worker3.doWork();
//    }
//
//    public static void main(String [] args) {
//        Worker1 w1 = new Worker1();
//        Worker2 w2 = new Worker2();
//        Worker3 w3 = new Worker3();
//
//        Manager m = new Manager(w1, w2, w3);
//    }
//}
