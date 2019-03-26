package Code.Trees;

/**
 * Created by developer on 9/27/17.
 */
public class Grid {
    protected boolean[][] myGrid; // my grid is where I will fill colors
    protected int length;
    protected int width;
    protected boolean[][] visited;//Another array to represent visited

    public Grid(int length, int width){
        myGrid = new boolean[length][width];
        this.length=length;
        this.width=width;
        visited = new boolean[length][width];

        //initialize with false
        for(int i=0; i<length; i++)
            for(int j=0; j<width; j++)
                myGrid[i][j]=false;

        for(int i=0; i<length; i++)
            for(int j=0; j<width; j++)
                visited[i][j]=false;
    }

    public void blockCell(int x, int y){
        if(x<this.length && y< this.width)
        this.myGrid[x][y]=true;
    }

    public boolean getCellValue(int x, int y){
        return this.myGrid[x][y];
    }

    public boolean[][] getMyGrid() {
        return this.myGrid;
    }

    public boolean getVisited(int x, int y) {
        return this.visited[x][y];
    }

    public void setVisited(int x, int y, boolean visited) {
         this.visited[x][y]=visited;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
