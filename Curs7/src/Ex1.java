import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Locale;

public class Ex1 {

    interface IPerson{
        void walk();
        @LogExecutionTime
        void drink();
        String getName();
    }

    static class Person implements IPerson{
        private String name;

        private Person(Builder builder){
            this.name = builder.name;
        }

        @Override
        public String getName() {
            return name;
        }

        public static class Builder{
            private String name;

            public Builder(String name){
                this.name = name;
            }

            public Builder setName(String name){
                this.name = name;
                return this;
            }

            public Builder(){
                this.name = "";
            }

            public IPerson build(){
                return (IPerson) Proxy.newProxyInstance(PersonInvocationHandler.class.getClassLoader(),
                        new Class[]{IPerson.class}, new PersonInvocationHandler(new Person(this)));
            }

        }

        @Override
        public void drink() {
            System.out.println(this.name + " is drinking!");
        }

        @Override
        public void walk() {
            System.out.println(this.name + " is walking!");
        }
    }

    public static void main(String[] args){
        IPerson person = new Person.Builder().setName("John").build();
        person.walk();
        person.drink();
    }



}
