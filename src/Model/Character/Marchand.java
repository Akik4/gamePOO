package Model.Character;

import Model.Event.Interact;

public class Marchand implements Interact {
    @Override
    public void interagir() {
        System.out.println("VOus parlez au marchand");
    }
}
