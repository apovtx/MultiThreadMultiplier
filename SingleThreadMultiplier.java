import java.util.LinkedList;


public class SingleThreadMultiplier {
	private int[][] result;
	private LinkedList<int[][]> matrices;
	
	SingleThreadMultiplier(LinkedList<int[][]> matrices) {
		System.out.println("From single! Size: " + matrices.size());
		this.matrices = matrices;
		if(this.matrices.isEmpty())
			return;
		
		this.result = this.matrices.removeFirst();
		for(int[][] m:this.matrices) {
			MatrixThread a = new MatrixThread(m, this.result);
			try {
				a.join();
			} catch (InterruptedException e) {
				System.out.println("\"Join\" error!!!" + e);
				e.printStackTrace();
			}
			this.result = a.getResult();
		}
	}
	
	public int[][] getResult() {
		return this.result;
	}
}
