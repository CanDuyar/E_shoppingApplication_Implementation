import java.util.List;

/**
 * Trader operations
 */
public interface TraderService {

    /**
     * add new product
     *
     * @param productId            the product's id
     * @param name                 the product's name
     * @param hierarchicalCategory the product's hierarchicalCategory
     * @param price                the product's price
     * @param discountAmount       the product's discountAmount
     * @param description          the product's description
     * @param traderName           the product's traderName
     */
    void addProduct(String productId, String name, String hierarchicalCategory, int price, int discountAmount,
                    String description, String traderName);

    /**
     * remove the product by product id
     *
     * @param productId the product's id
     */
    void removeProduct(String productId);

    /**
     * updates old product by product objects informations
     *
     * @param oldProductId      the product's id
     * @param newName           the product's new name
     * @param newCategory       the product's new category
     * @param newPrice          the product's new price
     * @param newDiscountAmount the product's new discount amount
     * @param newDescription    the product's new description
     * @param oldTraderName     the product's old trader name
     */
    void updateProduct(String oldProductId, String newName, String newCategory, int newPrice, int newDiscountAmount,
                       String newDescription, String oldTraderName);

    /**
     * display orders by customer id and trader id
     *
     * @param traderId   the order's trader id
     * @param customerIdList the order's customer id list
     */
    void displayOrdersByCustomers(long traderId, List<Long> customerIdList);

    /**
     * cancel order,
     * update order state as cancelled
     *
     * @param productId the order's product id
     */
    void cancelOrder(String productId);

    /**
     * accept order,
     * update order state as accepted
     *
     * @param productId the order's product id
     */
    void acceptOrder(String productId);
}
