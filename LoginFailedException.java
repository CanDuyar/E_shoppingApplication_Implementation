/**
 * Exception during login operation.
 */
public class LoginFailedException extends Exception {

    /**
     * Creates a LoginFailedException
     *
     * @param message message of Exception
     */
    public LoginFailedException(String message) {
        super(message);
    }

}
