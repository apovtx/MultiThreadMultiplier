import java.util.LinkedList;


public class Mymain {

	public static void main(String[] args) {
		long startTimeMulti, startTimeSingle;
		long endTimeMulti, endTimeSingle;
		LinkedList<int[][]> matrices = new LinkedList<int[][]>();
		LinkedList<int[][]> matrices2 = new LinkedList<int[][]>();
		//RandomMatrixGenerator.N = 2;
		RandomMatrixGenerator.N = 64;
		RandomMatrixGenerator.generateMatrix("matrix", 16);
		
		for(int i=0; i<16;i++) {
			matrices.add(Matrix.readMatrix("matrix"+i));
			matrices2.add(Matrix.readMatrix("matrix"+i));
			
		}
		
		startTimeSingle = System.currentTimeMillis();
		new SingleThreadMultiplier(matrices2);
		endTimeSingle = System.currentTimeMillis();
		System.out.println("Single thread execution time: "+ (endTimeSingle-startTimeSingle));
		
		
		startTimeMulti = System.currentTimeMillis();
		new MultiThreadMultiplier(matrices);
		endTimeMulti = System.currentTimeMillis();
		System.out.println("Multi thread execution time: "+ (endTimeMulti-startTimeMulti));
		
		

	}

}
