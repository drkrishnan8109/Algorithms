package Code.Trees;

//Find the number of cells in a grid
// that has been filled in with some values already.


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by developer on 9/27/17.
 */
public class BlockedGrid{

   /* BlockedGrid(){
        super(10,10); //Since Grid has an explicit constructor,
        // the child class has to call it with its parameters.
        // Even if it was parameter less, it has to be called
        // if there is any explicit constructor.
    }*/

    //public int[] stack;
    public int countBlocked(Grid grid){
        int[][] cache= new int[grid.getLength()][grid.getWidth()];
        return countBlocked(grid,0,0, cache);
    }

    public int countBlocked(Grid grid, int x, int y, int[][] cache) {
        // index 0 to x-1 and 0 to y-1
        if (x >= grid.getLength() || y >= grid.getWidth())
            return 0; //extremes
        else if (grid.getVisited(x,y) == true)
            return 0;
        else {
            int c = 0;
            grid.setVisited(x, y, true);
            if(grid.getCellValue(x,y)==true) c = 1;
            if(cache[x][y]!=0) return cache[x][y];
            else{
                cache[x][y] = c
                    + countBlocked(grid, x, y + 1, cache)
                    + countBlocked(grid, x + 1, y, cache);
                return cache[x][y];
            }
        }
    }

    @Test
    public void blockOutsideGridTest(){
        Grid myGrid = new Grid(5,6);
        myGrid.blockCell(5,7);
        BlockedGrid blockedGrid = new BlockedGrid();
        int count= blockedGrid.countBlocked(myGrid);
        assertEquals(0,count);
    }

    @Test
    public void blockValidGrid(){
        Grid myGrid = new Grid(5,6);
        myGrid.blockCell(0,0);
        myGrid.blockCell(1,0);
        myGrid.blockCell(3,4);
        BlockedGrid blockedGrid = new BlockedGrid();
        int count= blockedGrid.countBlocked(myGrid);
        assertEquals(3,count);
    }

}
