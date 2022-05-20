package Java;
//declaring default values and methods
public class Price {
    int age;
    String gender;
    float basePrice = 300f;
//setting up this user
    public Price(User user) {
        this.age = user.age;
        this.gender = user.gender;
    }
//calculations to get price
    public float getPrice() {
        float actualPrice = basePrice;
        if (gender.equals("female")) {
            actualPrice = basePrice * (1 - 0.25f);
        }
        if (age <= 12) {
            return actualPrice * 0.5f;
        }
        if (age >= 60) {
            actualPrice -= actualPrice * 0.6f;

            return actualPrice;
        }
        return actualPrice;
    }
}
