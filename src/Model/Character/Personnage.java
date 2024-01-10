package Model.Character;

public class Personnage {
    private String nom; 
    private float pointsDeVie;
    private float force;

    public Personnage(String nom, float pointsDeVie, float force) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
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

    public void attaquer()
    {
        System.out.println("Attaquer");
    }

    public void defendre()
    {
        System.out.println("defendre");
    }
}
