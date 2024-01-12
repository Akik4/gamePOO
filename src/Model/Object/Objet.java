package Model.Object;


import Model.Event.Interact;

public class Objet implements Interact {

    private float weight;
    private String name;
    private String description;
    private int price;

    public Objet(float weight, String name, String description, int price) {
        this.weight = weight;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void interagir()
    {
        System.out.println("utilisé");
    }
}
