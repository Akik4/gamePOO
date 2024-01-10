package Model.Object.Armes;

import Model.Object.Weapon;

public class Sword extends Weapon {
    public Sword(float weight, String name, String description, float damage, boolean type) {
        super(10, "Elucidator(épée)", "l'épée de Kirito", 20, type, 2);

    }

    @Override
    public void recharger() {
    }

    @Override
    public void attackWeapon() {

    }
}
