import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Product file operations
 */
public class ProductFile {

    /**
     * product file path
     */
    private final static String PATH_PRODUCT = "products.txt";

    /**
     * get products of trader by trader name
     *
     * @param traderName trader's name
     * @return list of product
     */
    public List<Product> getProductsOfTrader(String traderName) {
        List<Product> productList = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_PRODUCT))) {

            String currentLine;
            while ((currentLine = br.readLine()) != null) {

                String[] splittedCurrentLine = currentLine.split("\t");

                String traderNameFromTextFile = splittedCurrentLine[6];

                if (traderName.equals(traderNameFromTextFile)) {
                    String id = splittedCurrentLine[0];
                    String name = splittedCurrentLine[1];
                    String hierarchicalCategory = splittedCurrentLine[2];
                    int price = Integer.parseInt(splittedCurrentLine[3]);
                    int discountAmount = Integer.parseInt(splittedCurrentLine[4]);
                    String description = splittedCurrentLine[5];

                    Product product = new Product(id, name, hierarchicalCategory, price, discountAmount, description, traderName);
                    productList.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productList;
    }

    /**
     * get products with the search word in the name or description
     *
     * @param searchedWord searched word
     * @return list of product
     */
    public List<Product> getProductsByNameOrDescription(String searchedWord) {
        List<Product> productList = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_PRODUCT))) {

            String currentLine;
            while ((currentLine = br.readLine()) != null) {

                String[] splittedCurrentLine = currentLine.split("\t");

                String productNameFromTextFile = splittedCurrentLine[1];
                String descriptionFromTextFile = splittedCurrentLine[5];

                if (productNameFromTextFile.contains(searchedWord) || descriptionFromTextFile.contains(searchedWord)) {
                    String id = splittedCurrentLine[0];
                    String name = splittedCurrentLine[1];
                    String category = splittedCurrentLine[2];
                    int price = Integer.parseInt(splittedCurrentLine[3]);
                    int discountAmount = Integer.parseInt(splittedCurrentLine[4]);
                    String description = splittedCurrentLine[5];
                    String traderName = splittedCurrentLine[6];

                    Product product = new Product(id, name, category, price, discountAmount, description, traderName);
                    productList.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productList;
    }

    /**
     * remove the product by product id
     *
     * @param productId product id
     * @return returns true if process is successful
     */
    public boolean removeProduct(String productId) {
        File productsFile = new File(PATH_PRODUCT);
        File productsTempFile = new File("temp" + PATH_PRODUCT);

        boolean isRemoved = false;
        try (BufferedReader br = new BufferedReader(new FileReader(productsFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(productsTempFile))) {

            String currentLine;
            while ((currentLine = br.readLine()) != null) {

                String productIdFromTxt = currentLine.split("\t")[0];

                if (productId.equals(productIdFromTxt)) {
                    isRemoved = true;
                } else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        productsFile.delete();
        productsTempFile.renameTo(productsFile);

        return isRemoved;
    }

    /**
     * updates old product by product id
     *
     * @param productId      product id
     * @param updatedProduct new product object
     * @return returns true if process is successful
     */
    public boolean updateProduct(String productId, Product updatedProduct) {
        File productsFile = new File(PATH_PRODUCT);
        File productsTempFile = new File("temp" + PATH_PRODUCT);

        boolean isUpdated = false;
        try (BufferedReader br = new BufferedReader(new FileReader(productsFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(productsTempFile))) {

            String currentLine;
            while ((currentLine = br.readLine()) != null) {

                String productIdFromText = currentLine.split("\t")[0];

                if (productId.equals(productIdFromText)) {
                    isUpdated = true;
                    writer.write(updatedProduct.toString() + System.getProperty("line.separator"));
                } else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        productsFile.delete();
        productsTempFile.renameTo(productsFile);

        return isUpdated;
    }

    /**
     * add new product
     *
     * @param product product to add
     */
    public void addProduct(Product product) {
        try (FileWriter fw = new FileWriter(PATH_PRODUCT, true);
             PrintWriter out = new PrintWriter(fw)) {

            out.println(product);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
