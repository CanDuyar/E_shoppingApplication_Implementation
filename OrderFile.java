import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Order file operations
 */
public class OrderFile {

    /**
     * order file path
     */
    private final static String PATH_ORDER = "orders.txt";

    /**
     * get orders by list of customer id and order id
     *
     * @param traderId   trader id
     * @param customerIdList list of customer id
     * @return list of order
     */
    public Map<Long, ArrayList<Order>> getOrdersByCustomerIdAndOrderId(long traderId, List<Long> customerIdList) {
        Map<Long, ArrayList<Order>> orderHashtable = new Hashtable<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_ORDER))) {

            String currentLine;
            while ((currentLine = br.readLine()) != null) {

                String[] splittedCurrentLine = currentLine.split("\t");

                long traderIdFromText = Long.parseLong(splittedCurrentLine[0]);
                long customerIdFromText = Long.parseLong(splittedCurrentLine[1]);

                if (traderId == traderIdFromText && customerIdList.contains(customerIdFromText)) {
                    String productIdFromText = splittedCurrentLine[2];
                    OrderState stateFromText = OrderState.valueOf(splittedCurrentLine[3]);

                    Order order = new Order(traderIdFromText, customerIdFromText, productIdFromText, stateFromText);

                    if(orderHashtable.containsKey(customerIdFromText)) {
                        ArrayList<Order> orderArrayList = orderHashtable.get(customerIdFromText);
                        orderArrayList.add(order);
                    } else {
                        ArrayList<Order> orderArrayList = new ArrayList<>();
                        orderArrayList.add(order);
                        orderHashtable.put(customerIdFromText, orderArrayList);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orderHashtable;
    }

    /**
     * add new order
     *
     * @param order order to add
     */
    public void addOrder(Order order) {
        try (FileWriter fw = new FileWriter(PATH_ORDER, true);
             PrintWriter out = new PrintWriter(fw)) {

            out.println(order);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * update state of order
     *
     * @param productId product id
     * @param state     product state
     */
    public void updateOrderState(String productId, OrderState state) {
        File ordersFile = new File(PATH_ORDER);
        File ordersTempFile = new File("temp" + PATH_ORDER);

        try (BufferedReader br = new BufferedReader(new FileReader(ordersFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(ordersTempFile))) {

            String currentLine;
            while ((currentLine = br.readLine()) != null) {

                String[] splittedCurrentLine = currentLine.split("\t");

                String productIdFromText = splittedCurrentLine[2];
                OrderState stateFromText = OrderState.valueOf(splittedCurrentLine[3]);

                if (productId.equals(productIdFromText) && stateFromText.equals(OrderState.ADDED)) {
                    long traderIdFromText = Long.parseLong(splittedCurrentLine[0]);
                    long customerIdFromText = Long.parseLong(splittedCurrentLine[1]);

                    Order order = new Order(traderIdFromText, customerIdFromText, productIdFromText, state);
                    writer.write(order + System.getProperty("line.separator"));
                } else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ordersFile.delete();
        ordersTempFile.renameTo(ordersFile);
    }
}
