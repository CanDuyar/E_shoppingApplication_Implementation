/**
 * Trader information.
 */
public class Trader extends User {

    /**
     * Creates a Trader
     *
     * @param id       The Trader's id
     * @param password The Trader's password
     * @param name     The Trader's name
     */
    public Trader(long id, String password, String name) {
        super(id, password, name);
    }

    /**
     * Creates a Trader
     *
     * @param name The Trader's name
     */
    public Trader(String name) {
        super(name);
    }

    /**
     * Show menu information
     */
    @Override
    public void showMenu() {
        String menu = "Trader : " + getName() + System.getProperty("line.separator")
                + "1: "
                + "Add/Remove/Edit Products" + System.getProperty("line.separator")
                + "2: "
                + "See list of order" + System.getProperty("line.separator")
                + "3: "
                + "Accept/Cancel Orders" + System.getProperty("line.separator");

        System.out.println(menu);
    }
}
