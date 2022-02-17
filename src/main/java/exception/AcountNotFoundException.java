package exception;

import java.beans.ExceptionListener;

public class AcountNotFoundException extends Exception {
	@Override
	public String getMessage() {
		return "No Account Found!!";
	}
}
