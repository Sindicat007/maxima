package OopDop;

public class Human {
    private String name;
    private String lastName;
    private int age;

    private Human() {
    }

    public Human(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Имя: " + name +
                ", Фамилия: " + lastName +
                ", Возраст: " + age;
    }
}
