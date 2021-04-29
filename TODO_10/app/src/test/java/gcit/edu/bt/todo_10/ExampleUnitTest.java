package gcit.edu.bt.todo_10;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest{
    private calulator mcalculator;

    @Before
    public void setUp(){
        mcalculator = new calulator();
    }
    @Test
    public void addTwoNumber(){
        double result = mcalculator.add(1d, 2d);
        assertThat(result, is(equalTo(3d)));
    }
    @Test
    public void subTwoNumber(){
        double result = mcalculator.sub(3d, 2d);
        assertThat(result, is(equalTo(1d)));
    }
    @Test
    public void subWorksWithNegativeResults(){
        double result = mcalculator.sub(4d, 7d);
        assertThat(result, is(equalTo(-3d)));
    }
    @Test
    public void mulTwoNumbers(){
        double result = mcalculator.mul(3d, 2d);
        assertThat(result, is(equalTo(6d)));
    }

    @Test
    public void mulTwoNumbersZero(){
        double result = mcalculator.mul(1d, 0d);
        assertThat(result, is(equalTo(0d)));
    }
    @Test
    public void divTwoNumbers(){
        double result = mcalculator.div(6d,3d);
        assertThat(result, is(equalTo(2d)));
    }
    @Test
    public void divTwoNumbersZero(){
        double result = mcalculator.div(6d,0d);
        assertThat(result, is(equalTo(Double.POSITIVE_INFINITY)));
    }


}