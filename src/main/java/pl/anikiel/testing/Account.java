package pl.anikiel.testing;

public class Account {

    private boolean active;

    public Account() {
        active = false;
    }

    public void activate() {
        active = true;
    }

    public boolean isActive() {
        return active;
    }
}
