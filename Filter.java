/**
 * Used to filter products
 * Used private constructor and for arrive static of.. methods
 */
public final class Filter {

    /**
     * Filter's trader lowerBoundPrice
     */
    private int lowerBoundPrice;

    /**
     * Filter's trader upperBoundPrice
     */
    private int upperBoundPrice;

    /**
     * Filter's trader category
     */
    private String category;

    /**
     * Creates a filter.
     * private constructor
     */
    private Filter() {
    }

    /**
     * creates a filter for category filter operation
     *
     * @param category the filter's category
     * @return filter object
     */
    public static Filter ofCategory(String category) {
        Filter filter = new Filter();
        filter.category = category;
        return filter;
    }

    /**
     * creates a filter for upper bound price filter operation
     *
     * @param lowerBoundPrice the filter's lower bound price
     * @return filter object
     */
    public static Filter ofLowerBound(int lowerBoundPrice) {
        Filter filter = new Filter();
        filter.lowerBoundPrice = lowerBoundPrice;
        return filter;
    }

    /**
     * creates a filter for upper bound price filter operation
     *
     * @param upperBoundPrice the filter's upper bound price
     * @return filter object
     */
    public static Filter ofUpperBound(int upperBoundPrice) {
        Filter filter = new Filter();
        filter.upperBoundPrice = upperBoundPrice;
        return filter;
    }

    /**
     * creates a filter for range operation
     *
     * @param lowerBoundPrice the filter's lower bound price
     * @param upperBoundPrice the filter's upper bound price
     * @return filter object
     */
    public static Filter ofRangeBound(int lowerBoundPrice, int upperBoundPrice) {
        Filter filter = new Filter();
        filter.lowerBoundPrice = lowerBoundPrice;
        filter.upperBoundPrice = upperBoundPrice;
        return filter;
    }

    /**
     * This returns the lower bound price of this Filter
     *
     * @return this filter's lower bound price
     */
    public int getLowerBoundPrice() {
        return lowerBoundPrice;
    }

    /**
     * This returns the category of this Filter
     *
     * @return this filter's category
     */
    public String getCategory() {
        return category;
    }

    /**
     * This returns the upper bound price of this Filter
     *
     * @return this filter's upper bound price
     */
    public int getUpperBoundPrice() {
        return upperBoundPrice;
    }

    /**
     * controls that the category empty
     *
     * @return boolean
     */
    public boolean isCategory() {
        return category != null;
    }
}
