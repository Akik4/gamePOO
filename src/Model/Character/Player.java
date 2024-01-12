package Model.Character;

import Model.Object.Objet;
import Model.Object.Weapon;

import java.util.ArrayList;
import java.util.List;

import static Controller.gamebase.update;

public class Player extends Personnage{
    private int coins;
    private ArrayList<Objet> objectInventory = new ArrayList<Objet>();
    public Player(String nom, float pointsDeVie, float force, String symbole, Weapon arme, int coins) {
        super(nom, pointsDeVie, force, symbole, arme);
        this.coins = coins;
    }
    public int getCoins() {
        return coins;
    }
    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void attaquer(List<Ennemy> inRange)
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (!inRange.isEmpty()) {
            for (Ennemy toAttack : inRange) {
                toAttack.setPointsDeVie(toAttack.getPointsDeVie() - this.getForce() * this.getArme().getDamage());
            }
        }
    }
    public void defendre()
    {
        System.out.println("Joueur qui defend");
    }

    public ArrayList<Objet> getObjectInventory() {
        return objectInventory;
    }
    public void setObjectInventory(Objet newObject) {
        this.objectInventory.add(newObject);
    }
}
