/**
 * Abstract User information.
 */
public abstract class User {

    /**
     * User's id
     */
    private final long id;

    /**
     * User's password
     */
    private final String password;

    /**
     * User's name
     */
    private final String name;

    /**
     * Creates an User
     *
     * @param name The User's name
     */
    public User(String name) {
        this.name = name;
        this.id = Utils.createUniqueId();
        this.password = Utils.createPassword();
    }

    /**
     * Creates an User
     *
     * @param id       The User's id
     * @param password The User's password
     * @param name     The User's name
     */
    public User(long id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    /**
     * Abstract method, shows menu
     */
    abstract public void showMenu();

    @Override
    public String toString() {
        return "" + id
                + "\t" + password
                + "\t" + name;
    }

    /**
     * This returns the id of this User
     *
     * @return this user's id
     */
    public long getId() {
        return id;
    }

    /**
     * This returns the name of this User
     *
     * @return this user's name
     */
    public String getName() {
        return name;
    }

    /**
     * This returns the password of this User
     *
     * @return this user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This checks if passwords are the same
     *
     * @param password user's password
     * @return boolean
     */
    public boolean isPasswordSame(String password) {
        return this.password.equals(password);
    }
}
