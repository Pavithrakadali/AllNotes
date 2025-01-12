package reflection1;

import java.lang.reflect.Method;

public class DriverScript1 {
    public static void main(String[] args) {
        TestScript1 script = null;
        try{
            script = new TestScript1();

            Method arrTest[] = script.getClass().getMethods();
            for(int i=0; i<arrTest.length; i++){
                if(arrTest[i].getName().endsWith("User")){
                    arrTest[i].invoke(script);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            script = null;
        }
    }
}
