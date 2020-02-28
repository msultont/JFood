
/**
 * This is the main restaurant of JFood. Every object creation is created here
 * and all process is focused in this one class.
 *
 * @author Muhammad Sulton Tauhid
 * @version February 27th, 2020
 */
public class JFood {
    public static void main(String[] args) {
        Location location1 = new Location("Tangerang", "Banten", "Pusat");

        Seller seller1 = new Seller(1, "Sulton", "msulton55@gmail", "0822", location1);

        Food food1 = new Food(1, "Jengkol", seller1, 50000, "makanan");

        Customer customer1 = new Customer(1, "Sulton", "Gmail", "123asd", "Februari");

        Invoice invoice1 = new Invoice(1, 01, "27 Februari 2020", customer1, 100000);

        System.out.println(seller1.getName());
        seller1.setName("Fathur");
        food1.printData();
        System.out.println(seller1.getName());
        DatabaseSeller.addSeller(seller1);

        // customer1.printData();
        // invoice1.printData();
    }

}
