package Model.Object.Armes;

import Model.Object.Weapon;

public class Crossbow extends Weapon {
    public Crossbow(float weight, String name, String description, float damage, boolean type, int range) {
        super(10, "Marianne", "Arbalète de Daryl", 13, type, 10);
    }

    @Override
    public void recharger() {

    }

    @Override
    public void attackWeapon() {

    }
}
