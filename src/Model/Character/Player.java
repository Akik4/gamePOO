package Model.Character;

import Model.Object.Weapon;

public class Player extends Personnage{

    public Player(String nom, float pointsDeVie, float force, String symbole, Weapon arme) {
        super(nom, pointsDeVie, force, symbole, arme);
    }

    public void attaquer()
    {
        System.out.println("Joueur qui attaque");
    }

    public void defendre()
    {
        System.out.println("Joueur qui defend");
    }
}
