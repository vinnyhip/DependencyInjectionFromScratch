package services;

public class ServiceAImpl implements ServiceA {

    private ServiceB serviceB;

    @Override
    public ServiceB getServiceB() {
        return serviceB;
    }

    @Override
    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    @Override
    public String jobA() {
        return "jobA(" + serviceB.jobB() + ")";
    }
}
