import java.util.List;

/**
 * sort with bubble sort algorithm
 */
public class BubbleSort implements SortAlgorithm {

    /**
     * sort with bubble sort algorithm
     *
     * @param productList product list
     */
    public void sort(List<Product> productList) {
        Product tempProduct;
        if (productList.size() > 1) {

            for (int i = 0; i < productList.size(); i++) {
                for (int j = 0; j < productList.size() - i - 1; j++) {
                    if (productList.get(j).priceCompareTo(productList.get(j + 1)) > 0) {
                        tempProduct = productList.get(j);
                        productList.set(j, productList.get(j + 1));
                        productList.set(j + 1, tempProduct);
                    }
                }
            }
        }
    }

}
