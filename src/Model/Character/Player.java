package Model.Character;

import Model.Object.Weapon;

public class Player extends Personnage{
    private int coins;
    public Player(String nom, float pointsDeVie, float force, String symbole, Weapon arme) {
        super(nom, pointsDeVie, force, symbole, arme);
        this.coins = coins;
    }
    public int getCoins() {
        return coins;
    }
    public void setCoins(int coins) {
        this.coins = coins;
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
