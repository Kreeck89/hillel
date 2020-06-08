package farm.userlist;

public class Container {
    private User user;
    private Container nextContainer;

    public Container() {
    }

    public Container(User user, Container nextContainer) {
        this.user = user;
        this.nextContainer = nextContainer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Container getNextContainer() {
        return nextContainer;
    }

    public void setNextContainer(Container nextContainer) {
        this.nextContainer = nextContainer;
    }
}
