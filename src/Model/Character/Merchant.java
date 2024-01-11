package Model.Character;
import Model.Object.Armes.*;
import Model.Object.Objects.HealingPotion;
import Model.Object.Objects.StrengthPotion;
import Model.Object.Objet;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

public class Merchant {
    private ArrayList<Objet> MerchantObjectStock = new ArrayList<Objet>(); // Collection containing all purchasable items
    private ArrayList<Objet> MerchantWeaponStock = new ArrayList<Objet>(); // Collection containing all purchasable items

    public Merchant() {
        MerchantObjectStock.add(new HealingPotion());
        MerchantObjectStock.add(new HealingPotion());
        MerchantObjectStock.add(new StrengthPotion());

        MerchantWeaponStock.add(new Bow());
        MerchantWeaponStock.add(new Crossbow());
        MerchantWeaponStock.add(new Dagger());
        MerchantWeaponStock.add(new Spear());
        MerchantWeaponStock.add(new Sword());

    }
    public ArrayList<Objet> getMerchantObjectStock() {
        return MerchantObjectStock;
    }
    public ArrayList<Objet> getMerchantWeaponStock() {
        return MerchantWeaponStock;
    }


    public ArrayList<Objet> randomizedItemChoice() {
        /** This function randomly chooses 3 items from all purchasable items.
         * @param stock Collection containing all purchasable items.
         * @return Selected 3 items **/
        ArrayList<Objet> itemChoice = new ArrayList<Objet>();
        Random random = new Random();
        itemChoice.add(this.MerchantObjectStock.get(random.nextInt(0,7))); // 1 object

        for (int i = 0; i < 2; i++) {
            itemChoice.add(this.MerchantWeaponStock.get(random.nextInt(0,7))); // 2 weapons
        }
        return itemChoice;
    }

    public static boolean buy(int coins, Objet item) {
        /** This function verifies if the player has enough
         * coins to buy an item.
         * @param coins Coins of the player
         * @param item item the player is buying**/
        int itemPrice = item.getPrice();
        if (coins - itemPrice > 0) { // if enough coins
            return true;
        } else { // if not enough coins
            return false;
        }
    }
}