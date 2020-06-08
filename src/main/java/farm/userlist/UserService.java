package farm.userlist;

public class UserService {
    private Container container;

    public UserService() {
        container = new Container();
    }

    public void addUser(User user) {
        Container innerContainer = container;
        while (innerContainer.getNextContainer() != null) {
            innerContainer = innerContainer.getNextContainer();
        }
        innerContainer.setUser(user);
        innerContainer.setNextContainer(new Container());
    }

    public void addArrayOfUsers(Container userContainers) {
        Container innerContainer = container;
        while (innerContainer.getNextContainer() != null) {
            innerContainer = innerContainer.getNextContainer();
        }
        innerContainer.setUser(userContainers.getUser());
        innerContainer.setNextContainer(userContainers.getNextContainer());
    }

    public void removeUser(User user) {
        Container innerContainer = container;
        do {
            if (innerContainer.getUser() != null && innerContainer.getUser().equals(user)) {
                innerContainer.setUser(innerContainer.getNextContainer().getUser());
                innerContainer.setNextContainer(innerContainer.getNextContainer().getNextContainer());
                return;
            }
            innerContainer = innerContainer.getNextContainer();
        } while (innerContainer.getNextContainer() != null);
    }

    public void insertUserByIndex(User user, int index) {
        int counter = 0;
        Container innerContainer = container;
        do {
            if (counter == index) {
                Container temporaryContainer = new Container();
                temporaryContainer.setUser(innerContainer.getUser());
                temporaryContainer.setNextContainer(innerContainer.getNextContainer());
                innerContainer.setUser(user);
                innerContainer.setNextContainer(temporaryContainer);
            }
            innerContainer = innerContainer.getNextContainer();
            counter++;

        } while (innerContainer.getNextContainer() != null);
    }

    public void updateUserByIndex(User user, int index) {
        int counter = 0;
        Container innerContainer = container;
        do {
            if (counter == index) {
                innerContainer.setUser(user);
            }
            innerContainer = innerContainer.getNextContainer();
            counter++;

        } while (innerContainer.getNextContainer() != null);
    }

    public User findUserByName(String name) {
        Container innerContainer = container;
        do {
            if (innerContainer.getUser() != null && innerContainer.getUser().getName().equals(name)) {
                return innerContainer.getUser();
            }
            innerContainer = innerContainer.getNextContainer();

        } while (innerContainer.getNextContainer() != null);
        return null;
    }

    public void getUsersOrderedByAge() {

    }

    public void getUsersOrderedByName() {

    }
}
