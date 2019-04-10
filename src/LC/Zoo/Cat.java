package LC.Zoo;

public abstract class Cat extends Pets {
    int weight;
    int color;



    public Cat(int weight, int color, int price, String type) {
        super(price, type);
        this.weight = weight;
        this.color = color;
    }
    public Cat(int weight, int color) {
        this.weight = weight;
        this.color = color;
    }


    public void makeYouHappy() {
        System.out.println("scratch your face");
    }
    public void mew() {
        System.out.println("mew");
    }
}
