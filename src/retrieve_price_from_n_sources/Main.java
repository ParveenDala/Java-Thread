package retrieve_price_from_n_sources;

import java.util.Set;

/*******
 * Parveen D
 * Java Thread
 */
public class Main {
    public static void main(String[] args) {
        RetrievePrice retrievePrice = new RetrievePrice();
        Set<Integer> prices = retrievePrice.getPrices();

        for (Integer price : prices) {
            System.out.println(price);
        }
    }
}
