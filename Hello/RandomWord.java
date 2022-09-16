import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
	public RandomWord() {
		System.out.println("Inside constructor");
	}
	public static void main(String[] args){
		String che = "";
		int i =1;
		while (!StdIn.isEmpty()){
			String read = StdIn.readString();
			if (!StdRandom.bernoulli((double) (1 / i))){
				che = read;
			}
			i++;
		}
		StdOut.println(che);
	}
}
