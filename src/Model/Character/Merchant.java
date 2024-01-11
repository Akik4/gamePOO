package Model.Character;
import Model.Object.Armes.*;
import Model.Object.Objects.HealingPotion;
import Model.Object.Objects.StrengthPotion;
import Model.Object.Objet;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

public class Merchant {
    private ArrayList<Objet> MerchantStock = new ArrayList<Objet>(); // Collection containing all purchasable items

    public Merchant() {
        MerchantStock.add(new HealingPotion());
        MerchantStock.add(new HealingPotion());
        MerchantStock.add(new StrengthPotion());
        MerchantStock.add(new Bow());
        MerchantStock.add(new Crossbow());
        MerchantStock.add(new Dagger());
        MerchantStock.add(new Spear());
        MerchantStock.add(new Sword());

    }
    public ArrayList<Objet> getMerchantStock() {
        return MerchantStock;
    }

    public ArrayList<Objet> randomizedItemChoice() {
        /** This function randomly chooses 3 items from all purchasable items.
         * @param stock Collection containing all purchasable items.
         * @return Selected 3 items **/
        ArrayList<Objet> itemChoice = new ArrayList<Objet>();
        for (int i = 0; i < 3; i++) {
            Random random = new Random();
            itemChoice.add(this.MerchantStock.get(random.nextInt(0,7)));
        }
        return itemChoice;
    }

    public static int buy(int coins, Objet item) {
        /** This function verifies if the player has enough
         * coins to buy an item, and returns the player's coin balance
         * if purchase successful.
         * @param coins Coins of the player
         * @param item item the player is buying
         * @return new player coin balance **/
        int itemPrice = item.getPrice();
        if (coins - itemPrice > 0) { // if enough coins
            coins = coins - itemPrice;
            System.out.println("Item successfully bought!");
        } else { // if not enough coins
            System.out.println("Not enough coins :(");
        }
        return coins;
    }
}