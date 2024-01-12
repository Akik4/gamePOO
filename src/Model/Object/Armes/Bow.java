package Model.Object.Armes;

import Model.Object.Weapon;

public class Bow extends Weapon {
    public Bow() {
        super(10, "long Galadhrim", "Arc de Legolas", 10, false, 8, 65);
    }

    @Override
    public void recharger() {
    }

    @Override
    public void attackWeapon() {
    }
}
