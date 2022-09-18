import edu.princeton.cs.algs4.StdOut;

public class QuickUnionWeightedUF {
    int[] id;
    int[] sz;
    public QuickUnionWeightedUF(int N){
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i<N;i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int root(int i){
        while(i != id[i]) i = id[i];
        return i;
    }

    private boolean connected(int p, int q){
        return root(p) == root(q);
    }

    private void union(int p, int q){
        int k = root(p);
        int l = root(q);
         if(k == l) return;
         if(sz[k] < sz[l]){
             id[k] = l;
             sz[l] += sz[k];
             StdOut.println(sz[l]);
         }
         else{
             id[l] = k;
             sz[k] += sz[l];
             StdOut.println(sz[k]);
         }

    }

    public static void main(String[] args){
        QuickUnionWeightedUF qf = new QuickUnionWeightedUF(10);

        StdOut.println(qf.connected(2,3));

        qf.union(2,3);
        qf.union(3,6);
        qf.union(6,5);
        qf.union(1,5);
        qf.union(0,8);
        qf.union(4,9);
        qf.union(0,4);
        qf.union(2,0);

        System.out.println(qf.connected(2,5));

        StdOut.println(qf.connected(1,2));
    }

}
