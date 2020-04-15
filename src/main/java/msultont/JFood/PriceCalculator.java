package msultont.JFood;

public class PriceCalculator implements Runnable{
    private Thread t;
    private Invoice invoice;

    public PriceCalculator(Invoice invoice) {
        this.invoice = invoice;
        System.out.println("Creating invoice with ID : " + invoice.getId());
    }

    public void run() {
        System.out.println("Calculating Invoice ID: " + invoice.getId());
        invoice.setTotalPrice();
        System.out.println("Finish Calculating Invoice ID: " + invoice.getId());
    }

    public void start() {
        System.out.println("Starting Thread Invoice ID: " + invoice.getId());
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }

}