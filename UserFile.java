import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * User file operations
 */
public class UserFile {

    /**
     * user file path
     */
    private final static String PATH_USER = "users.txt";

    /**
     * Get the user by id.
     *
     * @param userId The user's id
     * @return user
     */
    public User getUser(long userId) {

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_USER))) {

            String currentLine;
            while ((currentLine = br.readLine()) != null) {

                String[] splittedCurrentLine = currentLine.split("\t");

                long idFromTextFile = Long.parseLong(splittedCurrentLine[0]);

                if (userId == idFromTextFile) {
                    String passwordFromTextFile = splittedCurrentLine[1];
                    String nameFromTextFile = splittedCurrentLine[2];

                    if (splittedCurrentLine[3].equals("TRADER")) {
                        return new Trader(userId, passwordFromTextFile, nameFromTextFile);
                    } else {
                        return new Customer(userId, passwordFromTextFile, nameFromTextFile);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
