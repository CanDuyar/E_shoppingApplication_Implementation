import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * File operations
 */
public class FileUtils {

    /**
     * products file path
     */
    private final static String PATH_PRODUCT = "products.txt";

    /**
     * users file path
     */
    private final static String PATH_USER = "users.txt";

    /**
     * orders file path
     */
    private final static String PATH_ORDER = "orders.txt";

    /**
     * add data from .csv file to queue
     * writes to file when there are 1000 data in the queue
     *
     * @param dataPath .csv file path
     */
    public static void initialize(String dataPath) {
        removeOldFiles();

        if (isFileExist(dataPath)) {
            Set<String> traderNameSet = new TreeSet<>();
            Queue<String> productQueue = new ArrayDeque<>();

            try (FileWriter fw = new FileWriter(PATH_PRODUCT, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {

                Path path = Paths.get(dataPath);

                Files.lines(path).skip(1).forEach(line -> {

                    String replacedLine = line.replaceAll(";", "\t");
                    productQueue.add(replacedLine);

                    if (productQueue.size() > 1000) {
                        writeToFile(out, productQueue);
                    }

                    String traderName = replacedLine.split("\t")[6];
                    traderNameSet.add(traderName);
                });
                writeToFile(out, productQueue);
            } catch (IOException e) {
            }

            createUserFile(traderNameSet);
        }
    }

    /**
     * control exist file
     *
     * @param dataPath sample .csv file path
     * @return if exist return true
     */
    private static boolean isFileExist(String dataPath) {
        File file = new File(dataPath);
        if (file.exists()) {
            return true;
        }
        throw new RuntimeException("File not found!");
    }

    /**
     * clear old orders.txt, products.txt and users.txt
     */
    private static void removeOldFiles() {
        File productFile = new File(PATH_PRODUCT);
        File orderFile = new File(PATH_ORDER);
        File userFile = new File(PATH_USER);

        productFile.delete();
        orderFile.delete();
        userFile.delete();
    }

    /**
     * Writes the information in the queue to the file
     *
     * @param out          printwriter
     * @param productQueue products to be written
     */
    private static void writeToFile(PrintWriter out, Queue<String> productQueue) {
        while (productQueue.peek() != null) {
            out.println(productQueue.poll());
        }
    }

    /**
     * create user file and add users to file
     *
     * @param traderNameSet trader name set
     */
    private static void createUserFile(Set<String> traderNameSet) {

        try (FileWriter fw = new FileWriter(PATH_USER, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            for (String customerName : createCustomer()) {
                out.println(new Customer(customerName) + "\tCUSTOMER");
            }

            for (String traderName : traderNameSet) {
                out.println(new Trader(traderName) + "\tTRADER");
            }

            out.println(new Trader(50000000, "123456", "testTraderName") + "\tTRADER");
            out.println(new Trader(50000001, "123456", "testCustomerName") + "\tCUSTOMER");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * creates mock customer
     *
     * @return mock customer set
     */
    private static Set<String> createCustomer() {
        Set<String> customerNameSet = new HashSet<>();
        customerNameSet.add("CustomerJack");
        customerNameSet.add("CustomerBob");
        return customerNameSet;
    }

}
