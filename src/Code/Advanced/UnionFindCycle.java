package Code.Advanced;

/**
 * Created by drkrishnan on 01.04.2018.
 */
public class UnionFindCycle {

    public int find(int[] parent, int i) {
        if(parent[i]==-1)
            return i;
        return find(parent,parent[i]);
    }

    public void union(int[] parent, int i, int j) {
        int rootI= find(parent, i);
        int rootJ= find(parent, j);

        parent[rootI]=rootJ;
    }
}
