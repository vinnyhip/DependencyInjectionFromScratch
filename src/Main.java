import services.ServiceA;
import services.ServiceAImpl;
import services.ServiceB;
import services.ServiceBImpl;

public class Main {

    public static void main(String args[]) {

        ServiceB serviceB = new ServiceBImpl();
        ServiceA serviceA = new ServiceAImpl(serviceB);

        System.out.println(serviceA.jobA());
    }
}
