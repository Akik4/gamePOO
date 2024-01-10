package Model;

public class map {


    int sizeX, sizeY;
    public String[][] test;


    public map(int sizeX, int sizeY)
    {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        test = new String[sizeX][sizeY];
    }

    public void generateMap()
    {
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
        StringBuilder display = new StringBuilder();

        for (String[] column : test)
        {
            display.append("\r\n");
            for(String row : column)
            {
                display.append(row).append(" ");
            }
        }

        System.out.println(display);
    }

    public void spawn(int x, int y, String visual)
    {
        test[x][y] = visual;
    }
}
