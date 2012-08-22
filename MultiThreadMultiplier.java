import java.util.LinkedList;


public class MultiThreadMultiplier {
	private int[][] result;
	private LinkedList<int[][]> matrices;
	
	MultiThreadMultiplier(LinkedList<int[][]> matrices) {
		System.out.println("From multi! Size: " + matrices.size());
		this.matrices = matrices;
		if(this.matrices.isEmpty())
			return;
		if(this.matrices.size()%2 != 0)
			this.matrices.add(this.getDummy());
		
		LinkedList<MatrixThread> threads = new LinkedList<MatrixThread>();
		while(this.matrices.size() != 1) {
			//Create threads for each phase 
			while(this.matrices.size()>1) {
				threads.add(new MatrixThread(this.matrices.removeFirst(), this.matrices.removeFirst()));
			}
			//Wait until all threads are finished
			for(MatrixThread t:threads) {
				try {
					t.join();
				} catch (InterruptedException e) {
					System.out.println("Interrupted exception! " + e);
					e.printStackTrace();
				}
			}
			for(MatrixThread t:threads) {
				this.matrices.add(t.getResult());
			}
			threads.clear();
		}
		this.result = this.matrices.removeFirst();
	}
	
	private int[][] getDummy() {
		int[][] temp = this.matrices.getFirst();
		for(int i=0; i<temp.length; i++)
			for(int j=0; j<temp.length; j++)
				temp[i][j] = 1;
		return temp;
	}
	
	public int[][] getResult() {
		return this.result;
	}
}
