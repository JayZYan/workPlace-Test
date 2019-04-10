package LC.Zoo;

public class Dog extends Pets {
    int weight;
    int color;


    public Dog(int weight, int color, int price, String type) {
        super(price, type);
        this.weight = weight;
        this.color = color;
    }
    @Override
    public void shit() {
        System.out.println("Dog Shit!");
    }
    public void shit(int i, int j) {
        System.out.println(i + j);
    }
    public void makeYouHappy() {
        System.out.println("Shit in your home");
    }

    public void wang() {
        System.out.println("wang");
    }
}
