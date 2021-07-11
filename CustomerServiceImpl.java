import java.util.List;

/**
 * Customer operations
 */
public class CustomerServiceImpl implements CustomerService {

    /**
     * Product file operations
     */
    private final ProductFile productFile = new ProductFile();

    /**
     * Order file operations
     */
    private final OrderFile orderFile = new OrderFile();

    /**
     * display products of trader by trader name, filter and sort according to criteria
     *
     * @param traderName trader name
     * @param criteria   sort criteria
     * @param filter     filter's information
     */
    @Override
    public void displayProductsOfTrader(String traderName, SortCriteria criteria, Filter filter) {
        List<Product> productList = productFile.getProductsOfTrader(traderName);
        filterProductListByFilterPojo(productList, filter);
        sortProductListBySortCriteria(productList, criteria);

        System.out.println("---Display Products of trader--");
        for (Product product : productList) {
            System.out.println(product);
        }
        System.out.println("Found '" + productList.size() + "' products. Trader Name: " + traderName);
        System.out.println();
    }

    /**
     * display products of trader by searched word in the name or description, filter and sort according to criteria
     *
     * @param searchedWord searched word
     * @param criteria     sort criteria
     * @param filter       filter's information
     */
    @Override
    public void displayProductsByNameOrDescription(String searchedWord, SortCriteria criteria, Filter filter) {
        List<Product> productList = productFile.getProductsByNameOrDescription(searchedWord);
        filterProductListByFilterPojo(productList, filter);
        sortProductListBySortCriteria(productList, criteria);

        System.out.println("---Display Products by name or description---");
        for (Product product : productList) {
            System.out.println(product);
        }
        System.out.println("Found '" + productList.size() + "' products. Searched Word: " + searchedWord);
        System.out.println();
    }

    /**
     * adds order
     *
     * @param traderId   trader id
     * @param customerId customer id
     * @param productId  product id
     */
    @Override
    public void addOrder(long traderId, long customerId, String productId) {
        Order order = new Order(traderId, customerId, productId);
        orderFile.addOrder(order);

        System.out.println("New order added. ProductId: '" + productId + "' CustomerId: '" + customerId + "' ProductId: '" + productId + "'");
    }

    /**
     * sort by criteria
     * a different algorithm is used according to the criteria
     *
     * @param productList product list
     * @param criteria    sort criteria
     */
    private void sortProductListBySortCriteria(List<Product> productList, SortCriteria criteria) {
        SortAlgorithm sortAlgorithm;

        switch (criteria) {
            case PRICE:
                System.out.println("sorted by price");
                sortAlgorithm = new BubbleSort();
                sortAlgorithm.sort(productList);
                break;
            case DISCOUNT_AMOUNT:
                System.out.println("sorted by discount amount");
                sortAlgorithm = new InsertionSort();
                sortAlgorithm.sort(productList);
                break;
            default:
                System.out.println("sorted by name");
                sortAlgorithm = new SelectionSort();
                sortAlgorithm.sort(productList);
                break;
        }
    }

    /**
     * filter product list by filter pojo
     *
     * @param productList product list
     * @param filter      filter pojo
     */
    private void filterProductListByFilterPojo(List<Product> productList, Filter filter) {
        if (filter == null) {
            return;
        }

        if (filter.isCategory()) {
            filterProductListByCategory(productList, filter.getCategory());
        } else {
            filterProductListByPrice(productList, filter);
        }
    }

    /**
     * filter product list by price
     *
     * @param productList product list
     * @param filter      filter pojo
     */
    private void filterProductListByPrice(List<Product> productList, Filter filter) {
        if (filter.getUpperBoundPrice() > 0) {
            filterProductListByBetweenRangePrice(productList, filter.getLowerBoundPrice(), filter.getUpperBoundPrice());
        } else if (filter.getLowerBoundPrice() > 0) {
            filterProductListByLowerBoundPrice(productList, filter.getLowerBoundPrice());
        }
    }

    /**
     * filter product list by lower bound price
     *
     * @param productList     product list
     * @param lowerBoundPrice lower bound price
     */
    private void filterProductListByLowerBoundPrice(List<Product> productList, int lowerBoundPrice) {
        productList.removeIf(product -> product.getPrice() < lowerBoundPrice);
    }

    /**
     * filter product list by lower bound price
     *
     * @param productList     product list
     * @param lowerBoundPrice lower bound price
     * @param upperBoundPrice upper bound price
     */
    private void filterProductListByBetweenRangePrice(List<Product> productList, int lowerBoundPrice, int upperBoundPrice) {
        productList.removeIf(product -> product.getPrice() < lowerBoundPrice || product.getPrice() > upperBoundPrice);
    }

    /**
     * filter product list by category
     *
     * @param productList product list
     * @param category    category
     */
    private void filterProductListByCategory(List<Product> productList, String category) {
        productList.removeIf(product -> !product.getCategory().contains(category));
    }

}
