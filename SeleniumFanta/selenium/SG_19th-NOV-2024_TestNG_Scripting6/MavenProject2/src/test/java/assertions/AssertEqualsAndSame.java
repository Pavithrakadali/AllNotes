package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertEqualsAndSame {
    @Test
    public void assertEqualsDemo(){
        String s1 = "SG Testing";
        String s2 = new String("SG Testing");
        Assert.assertEquals(s1, s2, "Both actual and expected are not matching");
    }


    @Test
    public void assertSameDemo(){
        String s1 = "SG Testing";
        String s2 = new String("SG Testing");
        Assert.assertSame(s1, s2, "Both actual and expected are not matching");
    }
}
