import java.util.Random;

/**
 * Generate id and password
 */
public class Utils {

    /**
     * Password length
     */
    private static final int PASSWORD_LENGTH = 6;

    /**
     * Id counter initial value
     */
    private static long ID_COUNTER = 10000000;

    /**
     * creates unique id
     *
     * @return unique id
     */
    public static long createUniqueId() {
        return ID_COUNTER++;
    }

    /**
     * creates random password
     *
     * @return random password
     */
    public static String createPassword() {
        int leftLimit = 65; // letter 'A'
        int rightLimit = 90; // letter 'Z'

        Random random = new Random();
        StringBuilder passwordBuilder = new StringBuilder(PASSWORD_LENGTH);

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomValue = random.nextInt(rightLimit - leftLimit + 1) + leftLimit;
            passwordBuilder.append((char) randomValue);
        }

        return passwordBuilder.toString();
    }

}
