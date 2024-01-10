package Model.Object.Armes;

import Model.Object.Weapon;

public class Bow extends Weapon {
    public Bow(float weight, String name, String description, float damage, boolean type, int range) {
        super(10, "long Galadhrim", "Arc de Legolas", 10, type, 8);
    }

    @Override
    public void recharger() {

    }

    @Override
    public void attackWeapon() {

    }
}
