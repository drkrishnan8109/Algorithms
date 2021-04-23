package Code.Design;
import java.util.Random;

import static java.util.stream.IntStream.range;

enum State {
    FREE, BLOCKED
}
class Cell {
    int x, y;
    State state = State.FREE;
    public Cell(int x, int y) {
        this.x =x;
        this.y =y;
    }
    @Override
    public String toString() {
        return Character.toString(state.toString().charAt(0));
    }
}

public class Maze {
    int x,y;
    Cell[][] grid;
    public Maze(int x, int y) {
        this.x=x;this.y=y;
        grid= new Cell[x][y];
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                grid[i][j] = new Cell(x,y);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    protected Random rand = new Random();

    public void divide(int x0, int y0, int width, int height) {
        if(width<=1 || height <=1 || x0>=this.x || y0>=this.y)
            return;
        //boolean isHorizontal = rand.nextInt()%2==0;
        boolean isHorizontal = width<height || (width==height && rand.nextBoolean());

        //I get IndexOutOfBounds sometimes!!
        if(isHorizontal){
            //pick random y from y0 + 1 to y0 + h-1
            //pick random door between x0 and x0 + width
            //x changes from x0 to x0 + width
            int y1 = y0 + 1 + rand.nextInt(height-1);
            int door = x0 + rand.nextInt( width);
            range(x0, x0 + width-1).filter(cx -> cx != door).forEach(ccx -> grid[ccx][y1].state = State.BLOCKED);
            divide(x0,y0,width, y1-y0);
            divide(x0,y1,width,height-(y1-y0));
        }
        else {
            ////pick random x  from x0+1 to x0 + w -1
            //y changes from y0 to y0 + height
            int x1 = x0 + 1 + rand.nextInt(width-1);
            int door = y0 + rand.nextInt(y0+height);
            range(y0,y0+height-1).filter(cy -> cy != door).forEach(ccy -> grid[x1][ccy].state = State.BLOCKED);
            divide(x0,y0,x1-x0,height);
            divide(x1,y0,width-(x1-x0),height);
        }
    }

    public static void main(String args[]) {
        Maze maze = new Maze(5,5);
        maze.divide(0,0,5,5);
        System.out.println(maze.toString());
    }
}
