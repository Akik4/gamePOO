package Model.Object.Objects;
import Model.Object.Objet;

public class HealingPotion extends Objet {
    private int healingPower = 10;

    public HealingPotion(float weight, String name, String description) {
        super(1, "Healing Potion", "This potion restores the player's health.");
    }
    public int getHealingPower() {
        return healingPower;
    }
}