package week_03.groupWork;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {
    @Test
    public void test1(){
        System.out.println("This is the first test.");
    }
    @Test
    public void test2(){
        System.out.println("This is the second test.");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This will execute before every methods");
    }

}
