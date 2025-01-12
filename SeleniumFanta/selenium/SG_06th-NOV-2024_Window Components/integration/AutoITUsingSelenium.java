package integration;

public class AutoITUsingSelenium {
    public static void main(String[] args) {
        String exeFilePath = null;
        try{
            exeFilePath = "C:\\MorningBatch_Combined\\autoItSampleScriptsDemo\\sampleNotepadTestScript.exe";
            Runtime.getRuntime().exec(exeFilePath);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            exeFilePath = null;
        }
    }
}
