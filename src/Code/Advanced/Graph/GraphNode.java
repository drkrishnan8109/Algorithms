package Code.Advanced.Graph;

public class GraphNode {
    String name;
    int node;
    int cost; // cost is distance in weighted graphs

    public GraphNode(String name) {
        this.name = name;
    }

    public GraphNode(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        return this.name.equals(((GraphNode)o).name);
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(this.name);
    }
}