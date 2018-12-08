import java.util.Objects;

public class PersonWithEqualsAndHash implements IPerson {
    private String name;
    private int age;

    public PersonWithEqualsAndHash(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        PersonWithEqualsAndHash person = (PersonWithEqualsAndHash) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }
}
