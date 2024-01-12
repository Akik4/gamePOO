package Model.Object.Objects;
import Model.Object.Objet;

public class StrengthPotion extends Objet {
    private int StrengthBoost = 20;

    public StrengthPotion() {
        super(1, "Strength Potion", "This potion boosts the player's strength.", 30);
    }
    public int getStrengthPotion() {
        return StrengthBoost;
    }
}
