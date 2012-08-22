
public class MatrixThread extends Thread {
	private int [][] m1;
	private int[][] m2;
	private int[][] res;
	
	
	public MatrixThread(int[][] m1, int[][] m2) {
		this.m1 = m1;
		this.m2 = m2;
		this.run();
	}
	
	public void run() {
		this.res = Matrix.multiply(this.m1, this.m2);
	}
	
	public int[][] getResult() {
		return this.res;
	}
	
}
