
package Code.Sorting;

/**
 * Created by developer on 10/1/17.
 * This program implements searching an element in a M*N matrix
 * which is sorted in ascending order
 */

//TO DO !!
public class SortedMatrixSearch {


/**
     * Search along diagonals. Whenever an element lies in between diagonal values,
     * then search the top-right and bottom.left matrix
     */

   /* public Coordinate searchMatrix(int[][] matrix, int rows, int cols, int element) {
        int i=0;
        if(matrix[0][0] > element || matrix[rows-1][cols-1] < element)
            return new Coordinate("Not found");
        while(i<rows) {
            // I could also do a binary search on the diagonal,
            // but here i do linear search
            if (matrix[i][i] == element) return new Coordinate(i, i);
            else if (matrix[i][i] < element && matrix[i++][i++] > element) {
                    return searchPartitions(i - 1, i, matrix, rows, cols, element);
                }
        }
        // Matrix might not be a square --> i.e., rows != cols

*//**     + + + + + + +
         *      + + + + + + +
         *      + + + + + + +
         *      OR
         *      + +
         *      + +
         *      + +
         *      + +
        *//*


        int diff = cols-rows;
        if(diff >= rows ){
            int[][] subMatrix = extractSubMatrix(matrix,0,rows+1,rows,cols);
            return searchMatrix(subMatrix, subMatrix.length-1, subMatrix[subMatrix.length-1].length-1 ,element);
        }else if(diff<0) {
            int[][] subMatrix = extractSubMatrix(matrix, 0, rows + 1, rows, cols);
            return searchMatrix(subMatrix, subMatrix.length - 1, subMatrix[subMatrix.length - 1].length - 1, element);
        }else {
            // search unequal matrix}
        }
    }

    public Coordinate searchPartitions(int l, int m, int[][] matrix, int rows, int cols, int element);
    {
        // top --> (0,m) to (m,col)
        // bottom --> (m,0) to (row,l)

    }
    public class Coordinate{
        Coordinate(int i, int j){
            System.out.println("Coordinates are :"+i+ "and"+ j);
        }
        Coordinate(String s){
            System.out.println(s);
        }
    }

*/
    public static void main(String args[]){

        int[][] matrix = {  {15,20,70,85},
                            {20,35,80,95},
                            {30,55,95,105},
                            {40,80,100,200}
                            };
        //System.out.println(matrix.length);
        //System.out.println(matrix[0].length);

        //rows-1, cols-1

    }

}

