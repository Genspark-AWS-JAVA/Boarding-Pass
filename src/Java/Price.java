package Java;

public class Price {
    int age = 21;
    String gender = "male";
    float basePrice = 300f;
    public Price(User user, BoardingPass boardingPass) {
    }
    public float getPrice(){
        if (gender .equals("female")){
            basePrice-=basePrice * 0.25;
        }
        if( age <= 12 ){
            basePrice-=basePrice * 0.50;
        }
        return basePrice;
    }
}
