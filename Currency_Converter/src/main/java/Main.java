import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public static void main(String[] args) {
    String apiEndpoint = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_cqkQHMOqphKtXGjszlEaaviyh1J3hURt1SSU6PzV";

    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(apiEndpoint))
            .GET()
            .header("Accept", "application/json")
            .build();

    try {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();
        String responseBody = response.body();

        System.out.println("Status Code: " + statusCode);
        JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
        //        String name = jsonObject.get("name").getAsString();
//        double value = jsonObject.get("value").getAsDouble();
//        IO.println(name + ": " + value);
        JsonObject data = jsonObject.getAsJsonObject("data");
        String currency = IO.readln("Please enter currency: ");
        double aud = data.get(currency).getAsDouble();

        //method to convert from usd to other currencies.
        String amount = IO.readln("How much USD do you want to convert: ");
        double dollarAmount = Double.parseDouble(amount);
        IO.println("Converted amount: " + (dollarAmount / aud));


    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }





//    String currency1Name = IO.readln("Please enter currency that you want to convert: ");
//    String currency2Name = IO.readln("Please enter currency you want to convert to: ");
//
//    String number = IO.readln("Please enter amount you would like to convert: ");
//    double currency1 = Double.parseDouble(number);
//
//    Currency currency = new Currency(currency1, currency1Name, currency2Name);
//
//    currency.convert_currency();
}

