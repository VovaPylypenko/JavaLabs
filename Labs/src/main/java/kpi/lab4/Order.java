package kpi.lab4;

public class Order {
    private Client seller;
    private double price;
    private String detail;

    public Order(Client seller, double price, String ditail) {
        this.seller = seller;
        this.price = price;
        this.detail = ditail;
    }

    public Client getSeller() {
        return seller;
    }

    public double getPrice() {
        return price;
    }

    public String getDetail() {
        return detail;
    }

    public Order setSeller(Client seller) {
        this.seller = seller;
        return this;
    }

    public Order setPrice(double price) {
        this.price = price;
        return this;
    }

    public Order setDetail(String detail) {
        this.detail = detail;
        return this;
    }
}
