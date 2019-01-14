public class Main {

    public static void main(String[] args) {
        Child c = new Child();
    }
}

class Parent {
    {System.out.println("Parent regular init block");}
    static {
        System.out.println("Parent static init block");
    }
    public Parent(){
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    public Child(){
        System.out.println("Child constructor");
    }
    {
        System.out.println("Child regular init block");
    }
    static {
        System.out.println("Child static block");
    }

}
