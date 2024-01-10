package Model.Object;

public abstract class Weapon extends Objet{

    private float damage;
    private boolean type;
    private int range;

    public Weapon(float weight, String name, String description, float damage, boolean type, int range) {
        super(weight, name, description);
        this.damage = damage;
        this.type = type;
        this.range = range;
    }

    public abstract void recharger();
    public abstract void attackWeapon();
}
