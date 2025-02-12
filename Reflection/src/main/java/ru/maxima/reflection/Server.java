package ru.maxima.reflection;

import ru.maxima.reflection.annotation.Component;
import ru.maxima.reflection.annotation.Scope;
import ru.maxima.reflection.annotation.Value;

@Scope
@Component
public class Server {
    @Value(port = "8181")
    private int port;

    void getPort() {
        System.out.println("Port " + port);
    }
}
