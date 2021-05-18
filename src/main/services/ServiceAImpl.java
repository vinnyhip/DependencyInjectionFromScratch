package main.services;

@Service
public class ServiceAImpl implements ServiceA {

    @Inject
    private ServiceB serviceB;

    @Override
    public String jobA() {
        return "jobA(" + serviceB.jobB() + ")";
    }
}
