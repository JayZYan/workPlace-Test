package LC.Zoo;

public class Driver {

    public static void main(String[] args) {
        //Cat cat = new Cat(100, 101, 102, "indoor");
        Dog dog = new Dog(100, 101, 1020, "outdoor");

        //Cat cat1 = new Cat(100, 101);


//
//
//        System.out.println(cat.color);
//        System.out.println(cat.weight);
//        System.out.println(cat.price);
//        System.out.println(cat.type);

        //cat.showPrice();
        dog.showPrice();

        //cat.shit();
        dog.shit(5, 6);
        dog.shit();

       // cat1.showPrice();

    }
}
