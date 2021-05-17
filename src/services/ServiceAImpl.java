package services;

public class ServiceAImpl implements ServiceA {

    private ServiceB serviceB;

    @Override
    public String jobA() {
        return "jobA(" + serviceB.jobB() + ")";
    }
}
