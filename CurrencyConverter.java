import java.util.*;
import java.text.DecimalFormat;

public class CurrencyConverter {

    public static final String[] exchangeRates = {
            "USD", "EUR", "GBP", "INR", "CNY", "JPY", "CAD", "AUD", "NZD", "KRW"
    };

    public static final double[] conversionRates = {
            1.0, 0.92, 0.78, 83.11, 7.23 , 146.0, 1.35 , 1.56 , 1.69, 1343.0
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount you want to convert: ");
        double amount = scanner.nextDouble();

        System.out.println("Enter the source currency:\"USD\", \"EUR\", \"GBP\", \"INR\", \"CNY\", \"JPY\", \"CAD\", \"AUD\", \"NZD\", \"KRW\" ");
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.println("Enter the destination currency: ");
        String destinationCurrency = scanner.next().toUpperCase();

        int sourceCurrencyIndex = Arrays.asList(exchangeRates).indexOf(sourceCurrency);
        int destinationCurrencyIndex = Arrays.asList(exchangeRates).indexOf(destinationCurrency);

        if (sourceCurrencyIndex == -1 || destinationCurrencyIndex == -1) {
            System.out.println("Invalid currency entered.");
            return;
        }

        double sourceToUSD = conversionRates[sourceCurrencyIndex];
        double destinationToUSD = conversionRates[destinationCurrencyIndex];

        double convertedToDestination = amount * (destinationToUSD / sourceToUSD);
        double convertedToSource = amount * (sourceToUSD / destinationToUSD);

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(amount) + " " + sourceCurrency + " = " + df.format(convertedToDestination) + " " + destinationCurrency);
        System.out.println(df.format(amount) + " " + destinationCurrency + " = " + df.format(convertedToSource) + " " + sourceCurrency);
    }
}
