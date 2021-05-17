package services;

public class ServiceBImpl implements ServiceB {

    @Inject
    private ServiceA serviceA;

    @Override
    public String jobB() {
        return "jobB()";
    }
}
