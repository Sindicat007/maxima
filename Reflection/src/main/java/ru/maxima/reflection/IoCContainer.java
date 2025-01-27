package ru.maxima.reflection;

import ru.maxima.reflection.annotation.Component;
import ru.maxima.reflection.annotation.Inject;
import ru.maxima.reflection.annotation.Scope;
import ru.maxima.reflection.annotation.Value;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IoCContainer {
    private final Set<Class<?>> prototypes = new HashSet<>();
    private final Map<Class<?>, Object> singletons = new HashMap<>();

    public IoCContainer() {
        scanComponents();
        injectDependencies();
    }

    private void scanComponents() {
        try {
            for (Class<?> clazz : new Class[]{Engine.class, Car.class, Server.class}) {
                if (clazz.isAnnotationPresent(Component.class)) {
                    if (clazz.isAnnotationPresent(Scope.class) && clazz.getAnnotation(Scope.class).value().equals("singleton")) {
                        singletons.put(clazz, clazz.getDeclaredConstructor().newInstance());
                    } else if (clazz.isAnnotationPresent(Scope.class) && clazz.getAnnotation(Scope.class).value().equals("prototype")) {
                        prototypes.add(clazz);
                    }

                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error creating components", e);
        }
    }

    private void injectDependencies() {
        singletons.values().forEach(instance -> {
            for (Field field : instance.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    try {
                        field.setAccessible(true);
                        field.set(instance, singletons.get(field.getType()));
                    } catch (Exception e) {
                        throw new RuntimeException("Error injecting dependencies", e);
                    }
                }
                if (field.isAnnotationPresent(Value.class)) {
                    try {
                        field.setAccessible(true);
                        field.set(instance, Integer.parseInt(field.getAnnotation(Value.class).port()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    public <T> T getInstance(Class<T> clazz) {
        if (prototypes.contains(clazz)) {
            try {
                return clazz.cast(clazz.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return clazz.cast(singletons.get(clazz));
    }
}
