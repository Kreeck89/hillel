package farm.userlist;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Container usersContainer = new Container();
        usersContainer.setUser(new User("Mila", 22));
        usersContainer.setNextContainer(new Container(new User("Masha", 19), null));
        User user = new User("Alex", 18);
        userService.addUser(user);
        User user2 = new User("Bob", 18);
        User user3 = new User("Oleg", 18);
        userService.addUser(user2);
        userService.addUser(user3);

        userService.addArrayOfUsers(usersContainer);

        userService.removeUser(user2);

        userService.insertUserByIndex(new User("Alisa Ivanovna", 54), 1);

        userService.updateUserByIndex(new User("Aliska", 45), 1);

        final User mila = userService.findUserByName("Mila");
        final User noUser = userService.findUserByName(null);

    }
}
