package Model.Character;

public class Player extends Personnage{

    public Player(String nom, float pointsDeVie, float force) {
        super(nom, pointsDeVie, force);
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
