/**
 * Used to log in.
 */
public class Session {

    /**
     * Provides access to the user file.
     */
    private final static UserFile userFile = new UserFile();

    /**
     * Controls the login process.
     *
     * @param id       id of the user to log in
     * @param password password of the user to log in
     * @return logged in user
     * @throws LoginFailedException exception during login operation.
     */
    public static User login(long id, String password) throws LoginFailedException {
        User user = userFile.getUser(id);

        if (user == null) {
            throw new LoginFailedException("User not found!!");
        }

        if (!user.isPasswordSame(password)) {
            throw new LoginFailedException("Wrong password!!");
        }

        System.out.println();
        System.out.println();
        System.out.println("----Signed in---- User id: " + id);
        System.out.println();
        user.showMenu();
        return user;
    }
}
