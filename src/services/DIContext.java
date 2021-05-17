package services;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DIContext {

    private final Set<Object> serviceInstances = new HashSet<>();

    public DIContext(Collection<Class<?>> serviceClasses) throws Exception {
        for(Class<?> serviceClass : serviceClasses) {
            Constructor<?> constructor = serviceClass.getConstructor();
            constructor.setAccessible(true);
            this.serviceInstances.add(constructor.newInstance());
        }

        for(Object serviceInstance : this.serviceInstances) {
            for(Field field : serviceInstance.getClass().getDeclaredFields()) {
                if(!field.isAnnotationPresent(Inject.class)) {
                    continue;
                }

                Class<?> fieldType = field.getType();
                field.setAccessible(true);

                for(Object matchPartner : this.serviceInstances) {
                    if(fieldType.isInstance(matchPartner)) {
                        field.set(serviceInstance, matchPartner);
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getServiceInstance(Class<T> serviceClass) {
        for(Object serviceInstance : this.serviceInstances) {
            if(serviceClass.isInstance(serviceInstance)) {
                return (T)serviceInstance;
            }
        }
        return null;
    }
}
