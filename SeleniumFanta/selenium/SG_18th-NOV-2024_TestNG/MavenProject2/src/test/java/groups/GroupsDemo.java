package groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsDemo {
    @Test(groups = "SMOKE")
    public void smokeTest1(){
       System.out.println("smoke test smokeTest1()");
    }

    @Test(groups = "SMOKE")
    public void smokeTest2(){
        System.out.println("smoke test smokeTest2()");
    }

    @Test(groups = "SMOKE")
    public void smokeTest3(){
        System.out.println("smoke test smokeTest3()");
    }

    @Test(groups = "SMOKE")
    public void smokeTest4(){
        System.out.println("smoke test smokeTest4()");
    }

    @Test(groups = "REGRESSION")
    public void regressionTest1(){
        System.out.println("regression test regressionTest1()");
    }

    @Test(groups = "REGRESSION")
    public void regressionTest2(){
        System.out.println("regression test regressionTest2()");
    }

    @Test(groups = "REGRESSION")
    public void regressionTest3(){
        System.out.println("regression test regressionTest3()");
    }

    @Test(groups = {"SMOKE", "REGRESSION"})
    public void configuration(){
        System.out.println("Pre-Requisite for all tests");
    }

    @BeforeGroups(value = "SMOKE")
    public void preRequisiteForSmoke(){
        System.out.println("Pre-Requisite for SMOKE");
    }

    @AfterGroups(value = "SMOKE")
    public void postRequisiteForSmoke(){
        System.out.println("Post-Requisite for SMOKE");
    }

    @BeforeGroups(value = "REGRESSION")
    public void preRequisiteForRegression(){
        System.out.println("Pre-Requisite for REGRESSION");
    }

    @AfterGroups(value = "REGRESSION")
    public void postRequisiteForRegression(){
        System.out.println("Post-Requisite for REGRESSION");
    }
}
