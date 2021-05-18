package main.services;

@Service
public class ServiceBImpl implements ServiceB {

    @Inject
    private ServiceA serviceA;

    @Override
    public String jobB() {
        return "jobB()";
    }
}
