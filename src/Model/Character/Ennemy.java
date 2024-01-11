package Model.Character;

import Model.Object.Weapon;

import java.util.Random;

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

    public void attaquer(Player joueur)
    {
        Random random = new Random();
        int rdn = random.nextInt(10);
        if(rdn >= 5)
        {
            joueur.setPointsDeVie(joueur.getPointsDeVie() - 100);
            System.out.println("Attaque ennemie reçu -2 hp");
        }
        //System.out.println("Ennemy qui attaque");
    }

    public void defendre()
    {
        System.out.println("Ennemy qui defend");
    }
}
