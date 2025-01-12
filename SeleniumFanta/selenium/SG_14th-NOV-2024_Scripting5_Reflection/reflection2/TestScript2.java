package reflection2;

public class TestScript2 {
    public static void createTest(){
        System.out.println("Test created successful");
    }

    public static void modifyTest(){
        System.out.println("Test modified successful");
    }

    public static void deleteTest(){
        System.out.println("Test deleted successful");
    }

    static {
        createTest();
        modifyTest();
        deleteTest();
    }
}
