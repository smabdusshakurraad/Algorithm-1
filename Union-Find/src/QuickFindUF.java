import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N){
        id = new int[N];
        for(int i = 0; i<N;i++){
            id[i] = i;
        }
    }

    private boolean connected(int p, int q){
        return id[p] == id[q];
    }

    private void union(int p, int q){
        int pid = id[p];
        int qid = id[q];

        for(int i = 0; i<id.length; i++){
            if(id[i] == pid) id[i] = qid;
        }
    }

    public static void main(String[] args){
        QuickFindUF qf = new QuickFindUF(10);

        System.out.println(qf.connected(2,3));

        qf.union(2,3);
        qf.union(3,6);
        qf.union(6,5);

        System.out.println(qf.connected(2,5));

        StdOut.println(qf.connected(1,2));
    }
}
