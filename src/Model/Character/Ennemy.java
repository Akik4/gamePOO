package Model.Character;

import Model.Object.Armes.Bow;
import Model.Object.Armes.BowEnnemy;
import Model.Object.Armes.Sword;
import Model.Object.Armes.SwordEnnemy;
import Model.Object.Objet;
import Model.Object.Weapon;

import java.util.ArrayList;
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

    public void attaquer(Player joueur)
    {
        Random random = new Random();
        int rdn = random.nextInt(10);
        if(rdn >= 5)
        {
            joueur.setPointsDeVie(joueur.getPointsDeVie() - this.getForce() * this.getArme().getDamage());
            System.out.println("Attaque ennemie reçu - " + (this.getForce() * this.getArme().getDamage()) + "hp");
        }
        //System.out.println("Ennemy qui attaque");
    }
    public void defendre()
    {
        System.out.println("Ennemy qui defend");
    }

    public boolean isType() {
        return type;
    }
    public void setType(boolean type) {
        this.type = type;
    }

    public ArrayList EnnemiesWeapon(){
        /** This function creates a collection
         * of a bow and sword Object for enemies.
         * @return EnnemyWeapon list of enemy Bow and Sword Objects **/
        ArrayList<Weapon> EnnemyWeapon = new ArrayList<Weapon>();
        EnnemyWeapon.add(new BowEnnemy());
        EnnemyWeapon.add(new SwordEnnemy());
        return EnnemyWeapon;

    public Weapon randomizedEnnemyWeapon() {
        /** This function randomly chooses 1 weapon
         * from all avaible weapons.
         * @return Selected 1 weapon **/
        Weapon weaponChoice = null;
        ArrayList<Weapon> EnnemyWeapon = EnnemiesWeapon();
        for (int i = 0; i < 1; i++) {
            Random random = new Random();
            weaponChoice = (EnnemyWeapon.get(random.nextInt(0,2)));
        }
        return weaponChoice;
    }
}
