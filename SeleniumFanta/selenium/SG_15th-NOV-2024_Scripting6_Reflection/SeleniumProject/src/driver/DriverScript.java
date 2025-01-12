package driver;

import datatable.Datatable;

import java.lang.reflect.Method;

public class DriverScript {
    public static void main(String[] args) {
        Class cls = null;
        Object obj = null;
        Datatable datatable = null;
        String filePath = System.getProperty("user.dir")+"\\Runner\\Runner.xlsx";
        Method script = null;
        boolean blnFalg = false;
        try{
            datatable = new Datatable();
            int rows = datatable.getRowCount(filePath, "testScripts");
            for(int r=1; r<=rows; r++){
                String scriptName = datatable.getCellData(filePath, "testScripts", "ScriptName", r);
                String className = datatable.getCellData(filePath, "testScripts", "ClassName", r);
                String executeTest = datatable.getCellData(filePath, "testScripts", "ExecuteTest", r);

                if(executeTest.equalsIgnoreCase("Yes")){
                    cls = Class.forName(className);
                    obj = cls.getDeclaredConstructor().newInstance();
                    script = obj.getClass().getMethod(scriptName);
                    script.invoke(obj);
                    blnFalg = true;
                    System.out.println("*******************************************************************");
                }
            }
            if(blnFalg==false){
                System.out.println("Please select atleast one script for execution");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
    }

}
