package Model.Character;
import Model.Object.Objet;
import java.util.ArrayList;
import java.lang.Math;

public class Merchant {
    private ArrayList<Objet> MerchantStock; // Collection containing all pruchasable items

    public Merchant(ArrayList<Objet> merchantStock) {
        MerchantStock = merchantStock;
    }
    public ArrayList<Objet> getMerchantStock() {
        return MerchantStock;
    }

    public ArrayList<Objet> randomizedItemChoice(ArrayList<Objet> stock) {
        /** This function randomly chooses 3 items from all purchasable items.
         * @param stock Collection containing all purchasable items.
         * @return Selected 3 items **/
        ArrayList<Objet> itemChoice = new ArrayList<Objet>();
        for (int i = 0; i < 3; i++) {
            itemChoice.add(stock.get((int) (Math.random()*10)));
        }
        return itemChoice;
    }

    public int buy(int coins, Objet item) {
        /** This function verifies if the player has enough
         * coins to buy an item, and returns the player's coin balance
         * if purchase successful.
         * @param coins Coins of the player
         * @param item item the player is buying
         * @return new player coin balance **/
        int itemPrice = item.getPrice();
        if (coins - itemPrice > 0) { // if enough coins
            coins = coins - itemPrice;
            System.out.println("Item succesfully bought!");
        } else { // if not enough coins
            System.out.println("Not enough coins :(");
        }
        return coins;
    }
}