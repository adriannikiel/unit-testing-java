package pl.anikiel.testing;

public class Account {

    private boolean active;
    private Address defaultDeliveryAddress;

    public Account() {
        active = false;
    }

    public void activate() {
        active = true;
    }

    public boolean isActive() {
        return active;
    }

    public Address getDefaultDeliveryAddress() {
        return defaultDeliveryAddress;
    }

    public void setDefaultDeliveryAddress(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
    }
}
