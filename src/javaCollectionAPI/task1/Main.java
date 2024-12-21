package javaCollectionAPI.task1;

public class Main {
    public static void main(String[] args) {

        ContactStorage phone = new ContactStorage();

        Launcher launcher = new Launcher(phone);
        launcher.launch();
    }
}
