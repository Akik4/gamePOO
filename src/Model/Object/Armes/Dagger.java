package Model.Object.Armes;

import Model.Object.Weapon;

public class Dagger extends Weapon {
    public Dagger(float weight, String name, String description, float damage, boolean type, int range) {
        super(10, "Arondight", "Dague de Lance L'eau", 30, type, 1);
    }

    @Override
    public void recharger() {

    }

    @Override
    public void attackWeapon() {

    }
}
