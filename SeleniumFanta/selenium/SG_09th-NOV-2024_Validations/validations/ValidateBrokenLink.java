package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ValidateBrokenLink {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.navigate().to("https://www.google.co.in/");
            Thread.sleep(2000);

            //Find the number of links and read their url's
            List<WebElement> links = ch.findElements(By.tagName("a"));
            for(int i=0; i<links.size(); i++){
                String strUrl = links.get(i).getAttribute("href");
                brokenLinks(strUrl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            ch = null;
        }
    }


    public static void brokenLinks(String linkURL){
        URL url = null;
        HttpURLConnection httpUrlConn = null;
        try{
            url = new URL(linkURL);
            httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setConnectTimeout(3000);
            httpUrlConn.connect();

            if(httpUrlConn.getResponseCode()==200){
                System.out.println(linkURL + " = " + httpUrlConn.getResponseMessage());
            }else{
                System.out.println(linkURL + " = " + HttpURLConnection.HTTP_NOT_FOUND);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            url = null;
            httpUrlConn = null;
        }
    }
}
