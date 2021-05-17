package services;

public class ServiceBImpl implements ServiceB {

    private ServiceA serviceA;

    @Override
    public ServiceA getServiceA() {
        return serviceA;
    }

    @Override
    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public String jobB() {
        return "jobB()";
    }
}
