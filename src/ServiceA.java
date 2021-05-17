public class ServiceA {

    private ServiceB serviceB;

    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public String jobA() {
        return "jobA(" + serviceB.jobB() + ")";
    }
}
