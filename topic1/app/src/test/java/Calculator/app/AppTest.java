package Calculator.app;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

	App cal = new App();

	@Test
    public void testsum()
    {
        assertEquals(8, cal.sum(2, 6));
    }
	@Test
    public void testsub()
    {
        assertEquals(4, cal.sub(10, 6));
    }

}