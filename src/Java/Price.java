package Java;

/**
 * Price of a ticket
 */
public class Price {
//declaring default values and methods
    /**
     * age of the customer
     */
    int age;
    /**
     * gender of the customer
     */
    String gender;
    /**
     * price of the ticket without discounts
     */
    float basePrice = 300f;

    /**
     * setting up this user
     *
     * @param user customer buying the ticket
     */
    public Price(User user) {
        this.age = user.age;
        this.gender = user.gender;
    }

    /**
     * calculations to get price
     *
     * @return price after discounts
     */
    public float getPrice() {
        float actualPrice = basePrice;
        if (gender.equals("female")) {
            actualPrice = basePrice * 0.75f;
        }
        if (age <= 12) return actualPrice * 0.5f;
        if (age >= 60) return actualPrice * 0.4f;
        return actualPrice;
    }
}
