package Java;

//declaring default values and methods
public class Price {
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
            actualPrice = basePrice * (1 - 0.25f);
        }
        if (age <= 12) return actualPrice * 0.5f;
        if (age >= 60) return actualPrice * (1 - 0.6f);
        return actualPrice;
    }
}
