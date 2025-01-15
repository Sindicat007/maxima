package javaIO;

public class UserChecked {

    public static void findUserById(int id) throws UserNotFoundException {
        if (id < 0) {
            throw new UserNotFoundException("Пользователь не найден");
        }
    }

    public static void main(String[] args) {
        try {
            findUserById(-1);
        } catch (UserNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
