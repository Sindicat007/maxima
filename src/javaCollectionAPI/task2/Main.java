package javaCollectionAPI.task2;


public class Main {
    public static void main(String[] args) {
        User alex = new User("Alex", 36);
        User victor = new User("Ivan", 25);
        User ivan = new User("Victor", 37);
        User rinat = new User("Rinat", 33);

        UsersList usersList = new UsersList();
        usersList.addUsers(alex);
        usersList.addUsers(ivan);
        usersList.addUsers(victor);
        usersList.addUsers(rinat);

        System.out.println(usersList.getUsers());
        NavigationUsersList navyLaunch = new NavigationUsersList();
        navyLaunch.navigationStart(usersList);
    }
}
