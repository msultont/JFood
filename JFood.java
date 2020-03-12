
/**
 * This is the main restaurant of JFood. Every object creation is created here
 * and all process is focused in this one class.
 *
 * @author Muhammad Sulton Tauhid
 * @version February 27th, 2020
 */
public class JFood {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Sulton", "gmail", "123", "06-03-2002");

        Promo promo1 = new Promo(55, "5msultont5", 10, 20000, true);

        Location location1 = new Location("Tangerang", "Banten", "Pusat");

        Seller seller1 = new Seller(1, "Sulton", "msulton55@gmail", "0822", location1);

        Food food1 = new Food(1, "Martabak", seller1, 50000, FoodCategory.Japanese);

        Food food2 = new Food(2, "Gorengan", seller1, 10000, FoodCategory.Rice);

        Food food3 = new Food(3, "Seblak", seller1, 30000, FoodCategory.Snacks);

        CashlessInvoice invoice1 = new CashlessInvoice(100, food1, "03/03/2020", customer1, InvoiceStatus.ONGOING);

        CashlessInvoice invoice2 = new CashlessInvoice(200, food2, "03/03/2020", customer1, InvoiceStatus.ONGOING,
                promo1);

        CashlessInvoice invoice3 = new CashlessInvoice(300, food3, "03/03/2020", customer1, InvoiceStatus.ONGOING,
                promo1);

        invoice1.setTotalPrice();
        invoice2.setTotalPrice();
        invoice3.setTotalPrice();

        invoice1.printData();
        invoice2.printData();
        invoice3.printData();

        // Customer customer1 = new Customer(1, "Sulton", "Gmail", "123asd",
        // "Februari");
        // Invoice invoice1 = new Invoice(1, 01, "27 Februari 2020", customer1, 100000);
        // System.out.println(seller1.getName());
        // seller1.setName("Fathur");
        // food1.printData();
        // System.out.println(seller1.getName());
        // DatabaseSeller.addSeller(seller1);
        // customer1.printData();
        // invoice1.printData();
    }

}
