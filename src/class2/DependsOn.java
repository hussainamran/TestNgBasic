package class2;

import org.testng.annotations.Test;

public class DependsOn {
    @Test
    public void login(){
        System.out.println(" I am first");
    }
    @Test(dependsOnMethods = "login")
    public void verificationOfDashboard(){
        System.out.println("I am dependent scenario");
    }
}
