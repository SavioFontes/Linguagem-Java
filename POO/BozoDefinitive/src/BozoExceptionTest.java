import static org.junit.Assert.*;

import org.junit.Test;

public class BozoExceptionTest {

	@Test
	public void testBozoException() {
		BozoException bozo = new BozoException("asdad");
		assertEquals("asdad",bozo.getMessage());
	}

}
