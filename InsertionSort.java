import java.util.List;

/**
 * sort with insertion sort algorithm
 */
public class InsertionSort implements SortAlgorithm {

    /**
     * sort with insertion sort algorithm
     *
     * @param productList product list
     */
    public void sort(List<Product> productList) {
        int i = 1, j;
        for (; i < productList.size(); i++) {
            Product tempProduct = productList.get(i);
            j = i;
            while ((j > 0) && (productList.get(j - 1).discountAmountCompareTo(tempProduct))) {
                productList.set(j, productList.get(j - 1));
                j--;
            }
            productList.set(j, tempProduct);
        }
    }

}
