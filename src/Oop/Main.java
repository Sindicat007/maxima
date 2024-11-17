package Oop;

public class Main {
    public static void main(String[] args) {
        Author levTolstoy = new Author("Лев", "Толстой");
        Author gerbertShield = new Author("Герберт", "Шилдт");

        Book warAndPeace = new Book("Война и мир", 1867, levTolstoy);
        Book javaInstruction = new Book("Рукводство по Java", 2019, gerbertShield);

        javaInstruction.setYear(2023);

        System.out.println(warAndPeace);
        System.out.println(javaInstruction);
    }
}
