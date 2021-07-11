import java.util.List;

/**
 * sort with selection sort algorithm
 */
public class SelectionSort implements SortAlgorithm{

    /**
     * sort with selection sort algorithm
     *
     * @param productList product list
     */
    public void sort(List<Product> productList) {
        for (int i = 0; i < productList.size(); i++) {
            int position = i;
            for (int j = i; j < productList.size(); j++) {
                if (productList.get(j).nameCompareTo(productList.get(position)) < 0) {
                    position = j;
                }
            }
            Product tempProduct = productList.get(position);
            productList.set(position, productList.get(i));
            productList.set(i, tempProduct);
        }
    }
}
