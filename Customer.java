/**
 * Customer information.
 */
public class Customer extends User {

    /**
     * Creates a Customer
     *
     * @param name The Customer's name
     */
    public Customer(String name) {
        super(name);
    }

    /**
     * Creates an Customer
     *
     * @param id       The Customer's id
     * @param password The Customer's password
     * @param name     The Customer's name
     */
    public Customer(long id, String password, String name) {
        super(id, password, name);
    }

    /**
     * Show menu information
     */
    @Override
    public void showMenu() {
        String menu = "Customer: " + getName() + System.getProperty("line.separator")
                + "1: "
                + "Search Products/Remove/Edit Products" + System.getProperty("line.separator")
                + "2: "
                + "Filter by Category/Prices" + System.getProperty("line.separator")
                + "3: "
                + "Display all of the products of a trader" + System.getProperty("line.separator");

        System.out.println(menu);
    }

}
