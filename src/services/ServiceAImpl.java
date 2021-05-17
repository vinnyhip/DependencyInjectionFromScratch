package services;

public class ServiceAImpl implements ServiceA {
    private ServiceB serviceB;

    public ServiceAImpl(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public String jobA() {
        return "jobA(" + serviceB.jobB() + ")";
    }
}
