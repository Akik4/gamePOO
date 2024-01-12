package Model.Object.Objects;
import Model.Object.Objet;

public class HealingPotion extends Objet {
    private int healingPower = 10;
    public HealingPotion() {
        super(1, "Healing Potion", "This potion restores the player's health.", 20);
    }
    public int getHealingPower() {
        return healingPower;
    }
}