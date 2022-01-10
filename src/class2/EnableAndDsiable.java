package class2;

import org.testng.annotations.Test;

public class EnableAndDsiable {

    @Test(groups = "smoke")
    public void firstTest(){

        System.out.println("I am the first");
    }
    @Test(groups = "smoke")
    public void secondTest(){

        System.out.println("I am the second");
    }

    @Test(enabled = false)
    public void thirdTest(){

        System.out.println("I am the third");
    }
}
