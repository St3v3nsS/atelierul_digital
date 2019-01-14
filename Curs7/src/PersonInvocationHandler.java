import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;

public class PersonInvocationHandler implements InvocationHandler {

    private Ex1.IPerson person;

    public PersonInvocationHandler(Ex1.IPerson obj){
        this.person = obj;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object result = null;
        LocalDateTime startTime = LocalDateTime.now();
        try {

            //System.out.println("Invoked method: {}" + method.getName());
            result = method.invoke(person, args);
            Annotation[] declaredAnnotation = method.getDeclaredAnnotations();
            if(declaredAnnotation.length != 0)
                System.out.println(person.getName() + " has been drinking for " + Duration.between(startTime, LocalDateTime.now()));
        }catch (Exception e){
            System.err.println(e);
        }

        return result;
    }


}