public class Currency {
    double currency1;
    double currency2;
    String currency1Name;
    String currency2Name;

    public Currency(double currency1, String currency1Name, String currency2Name) {
        this.currency1 = currency1;
        this.currency1Name = currency1Name;
        this.currency2Name = currency2Name;
    }

//    public void get_currency() {
//        currency1Name = IO.readln("Please enter currency that you want to convert: ");
//        currency2Name = IO.readln("Please enter currency you want to convert to: ");
//
//        String number = IO.readln("Please enter ammount you would like to convert: ");
//        currency1 = Double.parseDouble(number);
//    }

    public void convert_currency() {
        IO.println(currency1);
        IO.println(currency1Name);
        IO.println(currency2Name);

    }
}