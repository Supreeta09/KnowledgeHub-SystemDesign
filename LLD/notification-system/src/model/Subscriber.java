package model;

public class Subscriber {
    private final String subscriberId;
    private final String name;
    private final String email;
    private final String phone;

    public Subscriber(String subscriberId, String name, String email, String phone) {
        this.subscriberId = subscriberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
