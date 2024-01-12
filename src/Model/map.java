package Model;

import static Controller.gamebase.isGameOver;

public class map {

    private boolean merchantSequenceActivated;
    int sizeX, sizeY;
    public String[][] test;

    public boolean isMerchantSequenceActivated() {
        return merchantSequenceActivated;
    }
    public void setMerchantSequenceActivated(boolean merchantSequenceActivated) {
        this.merchantSequenceActivated = merchantSequenceActivated;
    }

    public map(int sizeX, int sizeY)
    {
        /** This function generates a map the size of the
         * instanciated object's sizeY and sizeY attributes. **/
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        test = new String[sizeX][sizeY];
    }

    public void generateMap()
    {
        /** This function modifies the collection
         * representing the map by replacing the item at a given
         * [x][y] index with "#" for walls and "." for
         * available positions. **/
        for (int y = this.sizeY - 1; y > -1 ; y--) {
            for (int x = this.sizeX - 1; x > -1 ; x--) {
                if(y == 0 | y == this.sizeY -1)
                {
                    test[y][x] = "#";
                } else {
                    if(x == 0 | x == this.sizeX - 1)
                    {
                        test[y][x] = "#";
                    } else {
                        test[y][x] = ".";
                    }
                }
            }
        }
    }

    public void display()
    {
        /** This function displays the map in the console. **/
        if (!merchantSequenceActivated || !isGameOver) {
            StringBuilder display = new StringBuilder();

            for (String[] column : test) {
                display.append("\r\n");
                for (String row : column) {
                    display.append(row).append(" ");
                }
            }
            System.out.println(display);
        }

    }

    public void spawn(int x, int y, String visual)
    { /** This function places the ennemy's symbol on
     the map.
     @param x columns
     @param y rows
     @param visual symbol **/
        test[y][x] = visual;
    }
}
