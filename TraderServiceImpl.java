import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Trader operations
 */
public class TraderServiceImpl implements TraderService {

    /**
     * Product file operations
     */
    private final ProductFile productFile = new ProductFile();

    /**
     * Order file operations
     */
    private final OrderFile orderFile = new OrderFile();

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
    @Override
    public void addProduct(String productId, String name, String hierarchicalCategory, int price, int discountAmount,
                           String description, String traderName) {
        Product product = new Product(productId, name, hierarchicalCategory, price, discountAmount, description, traderName);
        productFile.addProduct(product);

        System.out.println("New product added. ProductId: '" + productId + "'");
        System.out.println();
    }

    /**
     * remove the product by product id
     *
     * @param productId the product's id
     */
    @Override
    public void removeProduct(String productId) {
        if (productFile.removeProduct(productId)) {
            System.out.println("Product removed. ProductId: '" + productId + "'");
            System.out.println();
        } else {
            System.out.println("Product not found not removed. ProductId: '" + productId + "'");
            System.out.println();
        }
    }

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
    @Override
    public void updateProduct(String oldProductId, String newName, String newCategory, int newPrice, int newDiscountAmount,
                              String newDescription, String oldTraderName) {
        Product updatedProduct = new Product(oldProductId, newName, newCategory, newPrice, newDiscountAmount, newDescription, oldTraderName);
        if (productFile.updateProduct(oldProductId, updatedProduct)) {
            System.out.println("Product updated. ProductId: '" + oldProductId + "'");
            System.out.println();
        } else {
            System.out.println("Product not found not updated. ProductId: '" + oldProductId + "'");
            System.out.println();
        }
    }

    /**
     * display orders by customer id and trader id
     *
     * @param traderId   the order's trader id
     * @param customerIdList the order's customer id list
     */
    @Override
    public void displayOrdersByCustomers(long traderId, List<Long> customerIdList) {
        Map<Long, ArrayList<Order>> orderHashtable = orderFile.getOrdersByCustomerIdAndOrderId(traderId, customerIdList);

        System.out.println("---Display Orders By Customers---");
        for (Long customerId : orderHashtable.keySet()) {
            for (Order order : orderHashtable.get(customerId)) {
                System.out.println(order);
            }
        }

        long total = orderHashtable.values().stream().mapToLong(Collection::size).sum();
        System.out.println("Found '" + total + "' orders. TraderId: " + traderId);
        System.out.println();
    }

    /**
     * cancel order,
     * update order state as cancelled
     *
     * @param productId the order's product id
     */
    @Override
    public void cancelOrder(String productId) {
        updateOrderState(productId, OrderState.CANCELLED);
        System.out.println("Order cancelled. ProductId: '" + productId + "'");
        System.out.println();
    }

    /**
     * accept order,
     * update order state as accepted
     *
     * @param productId the order's product id
     */
    @Override
    public void acceptOrder(String productId) {
        updateOrderState(productId, OrderState.ACCEPTED);
        System.out.println("Order accepted. ProductId: '" + productId + "'");
        System.out.println();
    }

    /**
     * update order state by product id
     *
     * @param productId the order's product id
     * @param state     the order's new state
     */
    private void updateOrderState(String productId, OrderState state) {
        orderFile.updateOrderState(productId, state);
    }

}
