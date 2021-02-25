package flik;
import org.junit.Test;
import org.junit.Assert;

public class TestFlik {

    @Test
    public void test1() {
        for (int i = 138, j = 138; i < 300; i++, j++){
            Assert.assertTrue(Flik.isSameNumber(i, j));
        }
    }

}
