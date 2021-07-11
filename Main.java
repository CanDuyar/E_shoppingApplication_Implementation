import java.util.Collections;

/**
 * Main class
 */
public class Main {

    /**
     * Customer operations
     */
    private final static CustomerService customerService = new CustomerServiceImpl();

    /**
     * Trader operations
     */
    private final static TraderService traderService = new TraderServiceImpl();

    /**
     * logged in user
     */
    private static User user = null;

    /**
     * main method
     *
     * @param args .csv file path
     */
    public static void main(String... args) {
        FileUtils.initialize(args[0]);

        driverFunction();
    }

    /**
     * for test driver function
     */
    private static void driverFunction() {
        try {
            Session.login(999999L, "password");
        } catch (LoginFailedException e) {
            System.out.println(e.getMessage());
        }

        try {
            Session.login(10000000L, "invalidpassword");
        } catch (LoginFailedException e) {
            System.out.println(e.getMessage());
        }

        try {
            user = Session.login(50000000L, "123456");
        } catch (LoginFailedException e) {
            System.out.println(e.getMessage());
        }

        if (user instanceof Trader) {
            Trader trader = (Trader) user;
            traderService.addProduct("EXPEH2FF9KEPROD1", "Notebook_Name", "Electronic>>Computer>>Notebook", 10000, 6000, "Notebook_Description", trader.getName());
            traderService.addProduct("EXPEH2FF9KEPROD2", "Camera_Name", "Electronic>>Camera", 4000, 3000, "Camera_Description", trader.getName());
            traderService.addProduct("EXPEH2FF9KEPROD3", "Television_Name", "Electronic>>Television", 2500, 1500, "Television_Description", trader.getName());
            traderService.addProduct("EXPEH2FF9KEPROD4", "Headphones_Name", "Electronic>>Headphones", 500, 400, "Headphones_Description", trader.getName());
            traderService.addProduct("EXPEH2FF9KEPROD5", "Adventure_Name", "Book>>Adventure", 50, 40, "Adventure_Description", trader.getName());

            traderService.updateProduct("EXPEH2FF9KEPROD4", "updated_Headphones_Name", "Electronic>>Headphones", 600, 400, "Headphones_Description", trader.getName());
            traderService.updateProduct("INVALIDVALUE", "invalid_value", "invalid_value", 100, 100, "invalid_value", trader.getName());

            traderService.removeProduct("EXPEH2FF9KEPROD5");
            traderService.removeProduct("INVALIDVALUE");

        }

        try {
            user = Session.login(50000001L, "123456");
        } catch (LoginFailedException e) {
            System.out.println(e.getMessage());
        }

        if (user instanceof Customer) {
            Customer customer = (Customer) user;

            customerService.displayProductsOfTrader("testTraderName", SortCriteria.NAME, null);
            customerService.displayProductsOfTrader("testTraderName", SortCriteria.PRICE, null);
            customerService.displayProductsOfTrader("testTraderName", SortCriteria.DISCOUNT_AMOUNT, null);

            System.out.println("---Filter Operations--");
            customerService.displayProductsOfTrader("testTraderName", SortCriteria.NAME, Filter.ofCategory("Electronic"));
            customerService.displayProductsOfTrader("testTraderName", SortCriteria.NAME, Filter.ofLowerBound(2500));
            customerService.displayProductsOfTrader("testTraderName", SortCriteria.NAME, Filter.ofUpperBound(2500));
            customerService.displayProductsOfTrader("testTraderName", SortCriteria.NAME, Filter.ofRangeBound(500, 4000));

            customerService.displayProductsByNameOrDescription("_Name", SortCriteria.NAME, null);
            customerService.displayProductsByNameOrDescription("_Name", SortCriteria.PRICE, null);
            customerService.displayProductsByNameOrDescription("_Name", SortCriteria.DISCOUNT_AMOUNT, null);

            System.out.println("---Filter Operations--");
            customerService.displayProductsByNameOrDescription("_Name", SortCriteria.NAME, Filter.ofCategory("Electronic"));
            customerService.displayProductsByNameOrDescription("_Name", SortCriteria.NAME, Filter.ofLowerBound(2500));
            customerService.displayProductsByNameOrDescription("_Name", SortCriteria.NAME, Filter.ofUpperBound(2500));
            customerService.displayProductsByNameOrDescription("_Name", SortCriteria.NAME, Filter.ofRangeBound(500, 4000));


            customerService.addOrder(50000000, customer.getId(), "EXPEH2FF9KEPROD1");
            customerService.addOrder(50000000, customer.getId(), "EXPEH2FF9KEPROD4");
        }

        try {
            user = Session.login(50000000L, "123456");
        } catch (LoginFailedException e) {
            System.out.println(e.getMessage());
        }

        if (user instanceof Trader) {
            Trader trader = (Trader) user;

            traderService.displayOrdersByCustomers(trader.getId(), Collections.singletonList(501885L));
            traderService.displayOrdersByCustomers(trader.getId(), Collections.singletonList(50000001L));

            traderService.acceptOrder("EXPEH2FF9KEPROD1");
            traderService.cancelOrder("EXPEH2FF9KEPROD4");

            traderService.displayOrdersByCustomers(trader.getId(), Collections.singletonList(50000001L));
        }

    }

}
