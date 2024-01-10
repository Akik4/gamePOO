package Model.Object.Armes;

import Model.Object.Weapon;

public class Spear extends Weapon {
    public Spear(float weight, String name, String description, float damage, boolean type, int range) {
        super(10, "Gungnir(lance)", "Lance de Shojin" , 15, type, 3);
    }

    @Override
    public void recharger() {

    }

    @Override
    public void attackWeapon() {

    }
}
