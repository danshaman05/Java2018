import java.util.Arrays;

public class Pascal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.deepToString(triangle(5)));
	}
	public static int[][] triangle(int N){
		int[][] T = new int[N][];
		for (int i=0;i<N;i++) {
			T[i]=new int[i+1];
		}
		return T;
	}

}
