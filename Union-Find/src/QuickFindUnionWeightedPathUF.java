import edu.princeton.cs.algs4.StdOut;

public class QuickFindUnionWeightedPathUF {

    int[] id;
    int[] sz;

    public QuickFindUnionWeightedPathUF(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int p) {
        while (p != id[p]) { // condition for root node
            id[p] = id[id[p]]; // to update the path and the root of visited node

            p = id[p]; // go to that parent note

            //   id[p] = id[id[p]];
        }

        return p;
    }

    // if 2 nodes are connected they will have the same root
    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private void union(int p, int q){
        int k = root(p);
        int l = root(q);
        if(k == l) return; // if root are same then they are already connected
        //To change the root of smaller tree only
        if(sz[k] > sz[l]){
            id[l] = k;
            sz[k] += sz[l];
            StdOut.println(sz[k]);
        }
        else{
            id[k] = l;
            sz[l] += sz[k];
            StdOut.println(sz[l]);
        }
    }

    public static void main(String[] args){
        QuickFindUnionWeightedPathUF qf = new QuickFindUnionWeightedPathUF(10);

        StdOut.println(qf.connected(2,3));

        qf.union(2,3);
        qf.union(3,6);
        qf.union(6,5);
        qf.union(1,5);
        qf.union(0,8);
        qf.union(4,9);
//        qf.union(0,4);
//        qf.union(2,0);

        System.out.println(qf.connected(2,5));

//        StdOut.println(qf.connected(1,2));

        qf.union(0,4);
        qf.union(2,0);

        StdOut.println(qf.connected(1,2));

    }
}