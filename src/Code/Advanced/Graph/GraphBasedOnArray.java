package Code.Advanced.Graph;

import java.util.LinkedList;

public class GraphBasedOnArray {

        int size;
        boolean directed;

    public LinkedList<Integer>[] getAdjArray() {
        return adjArray;
    }

    public LinkedList<Integer>[] adjArray = new LinkedList[26];

        public GraphBasedOnArray(int size, boolean directed) {
            this.size=size;
            this.directed=directed;
            for(int i=0;i<size;i++) {
                adjArray[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int u, int v) {
            adjArray[u].add(v);
            if(directed)
                adjArray[v].add(u);
        }

        public boolean hasEdge( int u,  int v) {
            if(adjArray[u].contains(v))
                return true;
            return false;
        }

    public int getSize() {
        return size;
    }
    public boolean isDirected() {
        return directed;
    }
}
