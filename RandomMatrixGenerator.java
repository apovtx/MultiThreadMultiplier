import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class RandomMatrixGenerator {

	public static int N = 512;
	public static int MAX_VALUE= 1024;
	
	
	public static void generateMatrix(String name, int number) {
		try {
			for(int i = 0; i < number; i++) {
					Random random = new Random(System.currentTimeMillis());
					PrintWriter out = new PrintWriter(new FileWriter(name+i));
					for(int j = 0; j < N*N; j++) {
						out.println(random.nextInt(MAX_VALUE));
					}
					out.close();
			}
		} catch (IOException e) {
				System.out.println("Error creating file: " + e.getMessage());
			}		
	}

}
