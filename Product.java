/**
 * Trader's products
 */
public class Product {

    /**
     * Product's id
     */
    private final String id;

    /**
     * Product's name
     */
    private final String name;

    /**
     * Product's category.
     */
    private final String category;

    /**
     * Product's price
     */
    private final int price;

    /**
     * Product's discountAmount
     */
    private final int discountAmount;

    /**
     * Product's description
     */
    private final String description;

    /**
     * Product's traderName
     */
    private final String traderName;

    /**
     * Creates an Product.
     *
     * @param id             The product's id
     * @param name           The product's name
     * @param category       The product's category
     * @param price          The product's price
     * @param discountAmount The product's discount amount
     * @param description    The product's description
     * @param traderName     Trader of the product
     */
    public Product(String id, String name, String category, int price, int discountAmount, String description, String traderName) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.discountAmount = discountAmount;
        this.description = description;
        this.traderName = traderName;
    }

    /**
     * compares by price
     *
     * @param p value to compare
     * @return returns 1 if the value to compare is large, -1 if less, 0 if equal.
     */
    public int priceCompareTo(Product p) {
        if (price < p.price) {
            return 1;
        }
        if (price > p.price) {
            return -1;
        }
        return 0;
    }

    /**
     * compares by discountAmount
     *
     * @param p value to compare
     * @return returns true if the value to compare is large, false if less, false if equal.
     */
    public boolean discountAmountCompareTo(Product p) {
        if (discountAmount < p.discountAmount) {
            return true;
        }
        if (discountAmount > p.discountAmount) {
            return false;
        }
        return false;
    }

    /**
     * compares by name
     *
     * @param p value to compare
     * @return returns 1 if the value to compare is large, -1 if less, 0 if equal.
     */
    public int nameCompareTo(Product p) {
        return p.name.compareTo(name);
    }

    @Override
    public String toString() {
        return id + "\t"
                + name + "\t"
                + category + "\t"
                + price + "\t"
                + discountAmount + "\t"
                + description + "\t"
                + traderName;
    }

    /**
     * This returns the name of this Product
     *
     * @return this product's name
     */
    public String getName() {
        return name;
    }

    /**
     * This returns the price of this Product
     *
     * @return this product's price
     */
    public int getPrice() {
        return price;
    }

    /**
     * This returns the amount of this Product
     *
     * @return this product's discount amount
     */
    public int getDiscountAmount() {
        return discountAmount;
    }

    /**
     * This returns the category of this Product
     *
     * @return this product's category
     */
    public String getCategory() {
        return category;
    }

    /**
     * This returns the description of this Product
     *
     * @return this product's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This returns the id of this Product
     *
     * @return this product's id
     */
    public String getId() {
        return id;
    }

    /**
     * This returns the traderName of this Product
     *
     * @return this product's traderName
     */
    public String getTraderName() {
        return traderName;
    }
}
