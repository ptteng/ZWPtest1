package service;

import org.springframework.stereotype.Component;

@Component("ser")
public class TeacherService {
    public void doSomeService(){
        System.out.println("Do Some Thing");
    }
}
