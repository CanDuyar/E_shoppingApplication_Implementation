/**
 * Customer operations
 */
public interface CustomerService {

    /**
     * display products of trader by trader name, filter and sort according to criteria
     *
     * @param traderName trader name
     * @param criteria   sort criteria
     * @param filter     filter's information
     */
    void displayProductsOfTrader(String traderName, SortCriteria criteria, Filter filter);

    /**
     * display products of trader by searched word in the name or description, filter and sort according to criteria
     *
     * @param searchedWord searched word
     * @param criteria     sort criteria
     * @param filter       filter's information
     */
    void displayProductsByNameOrDescription(String searchedWord, SortCriteria criteria, Filter filter);

    /**
     * adds order
     *
     * @param traderId   trader id
     * @param customerId customer id
     * @param productId  product id
     */
    void addOrder(long traderId, long customerId, String productId);

}
