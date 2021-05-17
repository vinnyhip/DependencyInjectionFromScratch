import services.ServiceA;
import services.ServiceAImpl;
import services.ServiceB;
import services.ServiceBImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String args[]) throws Exception {
        Set<Class<?>> serviceClasses = new HashSet<>();
        serviceClasses.add(ServiceAImpl.class);
        serviceClasses.add(ServiceBImpl.class);

        ServiceA serviceA = createServiceA(serviceClasses);

        System.out.println(serviceA.jobA());
    }

    private static ServiceA createServiceA(Set<Class<?>> serviceClasses) throws Exception {

        Set<Object> serviceInstances = new HashSet<>();
        for(Class<?> serviceClass : serviceClasses) {
            Constructor<?> constructor = serviceClass.getConstructor();
            constructor.setAccessible(true);
            serviceInstances.add(constructor.newInstance());
        }

        for(Object serviceInstance : serviceInstances) {
            for(Field field : serviceInstance.getClass().getDeclaredFields()) {
                Class<?> fieldType = field.getType();
                field.setAccessible(true);

                for(Object matchPartner : serviceInstances) {
                    if(fieldType.isInstance(matchPartner)) {
                        field.set(serviceInstance, matchPartner);
                    }
                }
            }
        }

        for(Object serviceInstance : serviceInstances) {
            if(serviceInstance instanceof ServiceA) {
                return (ServiceA) serviceInstance;
            }
        }

        return null;
    }
}
