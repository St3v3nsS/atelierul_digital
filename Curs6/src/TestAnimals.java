public class TestAnimals {

    public static void main(String[] args){
        Fish d = new Fish();
        Cat c = new Cat("Fluffy");
        Animal a = new Fish();
        Animal e = new Spider();
        Pet p = new Cat();

        d.walk();
        d.eat();

        c.walk();
        c.eat();
        c.play();

        a.eat();
        a.walk();

        e.walk();
        e.eat();

        ((Cat) p).eat();
        ((Cat) p).walk();
        p.play();
        p.setName("Aurel");
        System.out.println(p.getName());

    }


}

abstract class Animal {
    private int legs;

    protected Animal(int legs) {
        this.legs = legs;
    }

    public void walk() {
        System.out.println("This animal has " + legs + " legs");
    }

    abstract public void eat();
}

class Spider extends Animal{

    public Spider(){
        super(8);
    }

    @Override
    public void eat() {
        System.out.println("Spiders eat everything");
    }


}

interface Pet{
    String getName();
    void setName(String name);
    void play();
}

class Cat extends Animal implements Pet{
    private String name;

    public Cat(String name){
        super(4);
        this.name = name;
    }

    public Cat(){
        this("");
    }

    @Override
    public void eat() {
        System.out.println("Cats eat mouses");
    }

    @Override
    public void play() {
        System.out.println("Cats play with their owners");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Fish extends Animal{

    public Fish(){
        super(0);
    }

    @Override
    public void walk() {
        System.out.println("Fish doesn't walk!");
    }

    @Override
    public void eat() {
        System.out.println("Fish eat all they can find in the ocean");
    }


}