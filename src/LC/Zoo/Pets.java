package LC.Zoo;

public abstract class Pets implements Animal{

    int price;
    String type;

    public Pets(int price, String type) {
        this.price = price;
        this.type = type;
    }
    public Pets() {
        price = 0;
        type = "unKnown";
    }
    public void shit() {
        System.out.println("Shit!");
    }

    abstract void makeYouHappy();

    void showPrice() {
        System.out.println(price);
    }
}
