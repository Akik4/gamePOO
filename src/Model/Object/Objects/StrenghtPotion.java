package Model.Object.Objects;
import Model.Object.Objet;

public class StrenghtPotion extends Objet {
    private int StrenghtBoost = 20;

    public StrenghtPotion(float weight, String name, String description) {
        super(1, "Strenght Potion", "This potion boosts the player's strenght.");
    }
    public int getStrenghtPotion() {
        return StrenghtBoost;
    }
}
