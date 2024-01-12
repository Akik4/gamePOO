package Model.Character;

import Model.Object.Objet;
import Model.Object.Weapon;

public class Personnage {
    private String nom; 
    private float pointsDeVie;
    private float force;

    private String symbole;

    private int cordX;
    private int cordY;

    private Weapon arme;

    public Personnage(String nom, float pointsDeVie, float force, String symbole, Weapon arme) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
        this.symbole = symbole;
        this.arme = arme;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(float pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public float getForce() {
        return force;
    }

    public void setForce(float force) {
        this.force = force;
    }

    public Weapon getArme() {
        return arme;
    }

    public void setArme(Weapon arme) {
        this.arme = arme;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public int getCordX() {
        return cordX;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
    }

    public void setCord(int cordX, int cordY)
    {
        setCordX(cordX);
        setCordY(cordY);
    }

    public void attaquer()
    {
        System.out.println("Attaquer");
    }

    public void defendre()
    {
        System.out.println("defendre");
    }
}
