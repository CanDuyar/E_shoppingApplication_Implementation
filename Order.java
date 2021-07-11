/**
 * Customer's order information
 */
public class Order {

    /**
     * Product's trader id
     */
    private final long traderId;

    /**
     * Product's customer id
     */
    private final long customerId;

    /**
     * Product's product id
     */
    private final String productId;

    /**
     * Product's state
     */
    private final OrderState state;

    /**
     * Creates an Order with specified state.
     *
     * @param traderId   The trader's id
     * @param customerId The customer's id
     * @param productId  The product's id
     */
    public Order(long traderId, long customerId, String productId) {
        this.traderId = traderId;
        this.customerId = customerId;
        this.productId = productId;
        this.state = OrderState.ADDED;
    }

    /**
     * Creates an Order.
     *
     * @param traderId   The trader's id
     * @param customerId The customer's id
     * @param productId  The product's id
     * @param state      The Order's state
     */
    public Order(long traderId, long customerId, String productId, OrderState state) {
        this.traderId = traderId;
        this.customerId = customerId;
        this.productId = productId;
        this.state = state;
    }

    @Override
    public String toString() {
        return traderId + "\t"
                + customerId + "\t"
                + productId + "\t"
                + state;
    }

    /**
     * This returns the customer's id of this Order
     *
     * @return this order's customer id
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * This returns the state of this Order
     *
     * @return this order's state
     */
    public OrderState getState() {
        return state;
    }

    /**
     * This returns the trader's id of this Order
     *
     * @return this order's trader's id
     */
    public long getTraderId() {
        return traderId;
    }

    /**
     * This returns the product's id of this Order
     *
     * @return this order's product's id
     */
    public String getProductId() {
        return productId;
    }
}
