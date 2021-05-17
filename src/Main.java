import services.ServiceA;
import services.ServiceAImpl;
import services.ServiceB;
import services.ServiceBImpl;

public class Main {

    public static void main(String args[]) {

        ServiceB serviceB = new ServiceBImpl();
        ServiceA serviceA = new ServiceAImpl();

        serviceA.setServiceB(serviceB);
        serviceB.setServiceA(serviceA);

        System.out.println(serviceA.jobA());
    }
}
