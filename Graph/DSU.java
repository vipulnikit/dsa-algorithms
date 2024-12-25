// Disjoint Set Union Algorithm
public class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int src) {
        if (src == parent[src]) {
            return src;
        }
        return parent[src] = findParent(parent[src]);
    }

    public void union(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);
        if (parentU != parentV) {
            parent[Math.max(parentU, parentV)] = Math.min(parentU, parentV);
        }
    }
}