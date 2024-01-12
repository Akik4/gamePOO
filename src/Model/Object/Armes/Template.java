package Model.Object.Armes;

import Model.Object.Weapon;

public class Template extends Weapon {

    public Template(float weight, String name, String description, float damage, boolean type, int range, int price) {
        super(weight, name, description, damage, type, range, price);
    }

    @Override
    public void recharger() {

    }

    @Override
    public void attackWeapon() {

    }
}
