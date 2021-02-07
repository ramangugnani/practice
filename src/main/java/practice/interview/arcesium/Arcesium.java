package practice.interview.arcesium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Arcesium {

    public static void main(String[] args) {

        System.out.println(calculateNAV("20190101"));

    }

    public static double calculateNAV(String date) {
        List<Holding> holdings = getHolding();
        List<Pricing> pricings = getPricing();

        // System.out.println(holdings);
        // System.out.println(pricings);

        Map<String, Pricing> dateByPricing = new HashMap<>();
        for (Pricing price : pricings) {
            dateByPricing.put(price.date + "-" + price.security, price);
        }
        Double totalHoldings = 0d;
        for (Holding holding : holdings) {
            if (holding.date.equals(date)) {
                Pricing priceObj = dateByPricing.get(holding.date + "-" + holding.security);
                // System.out.println("holding " + holding);
                // System.out.println("priceObj " + priceObj);
                Double price = priceObj.price;
                totalHoldings = totalHoldings + (holding.quantity * price);
            }
        }
        return totalHoldings;
    }

    private static List<Holding> getHolding() {
        List<Holding> holding = new ArrayList<>();
        Gson gson = new Gson();
        try {

            URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String line = null;
            String message = new String();
            while ((line = br.readLine()) != null) {
                message += line;
            }
            // System.out.println(message);
            Type listType = new TypeToken<ArrayList<Holding>>() {
            }.getType();
            holding = gson.fromJson(message, listType);
            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return holding;
    }

    private static List<Pricing> getPricing() {
        List<Pricing> pricing = new ArrayList<>();
        Gson gson = new Gson();
        try {

            URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String line = null;
            String message = new String();
            while ((line = br.readLine()) != null) {
                message += line;
            }
            // System.out.println(message);

            Type listType = new TypeToken<ArrayList<Pricing>>() {
            }.getType();
            pricing = gson.fromJson(message, listType);
            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pricing;
    }

    public static class Holding {
        public String date;
        public String security;
        public Integer quantity;
        public String portfolio;

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Holding [date=" + date + ", security=" + security + ", quantity=" + quantity + ", portfolio="
                    + portfolio + "]";
        }

    }

    public static class Pricing {
        public String date;
        public String security;
        public Double price;

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Pricing [date=" + date + ", security=" + security + ", price=" + price + "]";
        }

    }
}
