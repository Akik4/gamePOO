package Model.Object;

import Model.Object.Objet;

public abstract class Weapon extends Objet {

    private float damage;
    private boolean type;
    private int range;

    public Weapon(float weight, String name, String description, float damage, boolean type, int range, int price) {
        super(weight, name, description, price);
        this.damage = damage;
        this.type = type;
        this.range = range;
    }

    public abstract void recharger();
    public abstract void attackWeapon();

    public int getRange() {
        return range;
    }

    public float getDamage() {
        return damage;
    }
}
