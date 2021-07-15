
import com.nagarro.services.LoginService;

import junit.framework.*;

public class AppTest extends TestCase {

	LoginService loginService = new LoginService();

	public AppTest(String name) {
		super(name);
	}

	public void testValidUser() {
		assertEquals(true, loginService.validateUser("jatin", "pass"));
	}
	
	public void testNonValidUser() {
		assertEquals(false, loginService.validateUser("yash", "none"));
	}
}
