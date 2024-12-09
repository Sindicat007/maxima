package objectTask.task2;

public class Main {
    public static void main(String[] args) {

        Storage<String> stringCloud = new Storage<>();

        String first = "How are you?";
        String second = "I'm fine";
        String third = "Good";

        stringCloud.add(first);
        stringCloud.add(second);
        stringCloud.add(third);

        System.out.println(stringCloud.get(2));
        System.out.println(stringCloud);
    }
}
