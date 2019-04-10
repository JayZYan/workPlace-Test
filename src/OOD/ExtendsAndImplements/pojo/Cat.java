package OOD.ExtendsAndImplements.pojo;

public class Cat extends Animal {
    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + getWeight() +
                ", age=" + getAge() +
                ", name='" + getName() + '\'' +
                "} " + super.toString();
    }
}
