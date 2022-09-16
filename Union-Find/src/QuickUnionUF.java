import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
    int[] id;
    public QuickUnionUF(int N){
        id = new int[N];
        for(int i = 0; i<N; i++){
            id[i] = i;
        }
    }

    private int root(int i){
        while(i != id[i]) i= id[i];

        return i;
    }

    private boolean connected(int p, int q){
        return root(p) == root(q);
    }

    private void union(int p, int q){
        int k = root(p);
        int l = root(q);
        id[k] = l;
    }

    public static void main(String[] args){
        QuickUnionUF qf = new QuickUnionUF(10);

        StdOut.println(qf.connected(2,3));

        qf.union(2,3);
        qf.union(3,6);
        qf.union(6,5);

        System.out.println(qf.connected(2,5));

        StdOut.println(qf.connected(1,2));
    }
}
