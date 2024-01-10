package Model.Character;

import Model.Object.Weapon;

public class Ennemy extends Personnage{

    private boolean isKnockout;
    private boolean type;

    public Ennemy(String nom, float pointsDeVie, float force, String symbole, Weapon arme, boolean isKnockout, boolean type) {
        super(nom, pointsDeVie, force, symbole, arme);
        this.isKnockout = isKnockout;
        this.type = type;
    }

    public boolean isKnockout() {
        return isKnockout;
    }

    public void setKnockout(boolean knockout) {
        isKnockout = knockout;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void attaquer()
    {
        System.out.println("Ennemy qui attaque");
    }

    public void defendre()
    {
        System.out.println("Ennemy qui defend");
    }
}
