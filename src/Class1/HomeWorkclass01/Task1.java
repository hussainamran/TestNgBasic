package Class1.HomeWorkclass01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am pre condition");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am post condition");
    }
   @Test
    public void javaTest(){
        System.out.println("Executing the java code");
    }
    @Test
    public void seleniumTest(){
        System.out.println("Executing the selenium code");
    }
    @Test()
    public void gitTest(){
        System.out.println("Pushing the git code");
    }
}
