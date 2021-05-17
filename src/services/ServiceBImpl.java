package services;

public class ServiceBImpl implements ServiceB {

    private ServiceA serviceA;

    @Override
    public String jobB() {
        return "jobB()";
    }
}
