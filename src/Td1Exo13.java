import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

class CreateFile {
	
	public CreateFile() {}
	
	public void createFicher () throws FileNotFoundException{
		printToFile();
	}
	
	private void printToFile() throws FileNotFoundException{
		double[] p = new double[11];
		p[0] = 0.0;p[3] = 0.3;p[6] = 0.6;p[9] = 0.9;
		p[1] = 0.1;p[4] = 0.4;p[7] = 0.7;p[10] = 1.0;
		p[2] = 0.2;p[5] = 0.5;p[8] = 0.8;
		
		String ligne = readFromFile("string.bin");
		
		for(int i = 0; i < p.length; i++) {
			int ratio =  (int) (1000000*p[i]);
			PrintStream output = new PrintStream(new FileOutputStream("file_p"+i+".bin"));
			String[] carac = ligne.split("");
			while (ratio > 0) {
				int change = (int) (Math.random() * ((ligne.length() - 1) + 1));
				int info =  Integer.parseInt(carac[change]);
				if(info == 0) {
					carac[change] = "1";
					ratio -- ;
				}
			}
			String newLine = String.join("", carac);
			output.print(newLine);
			output.close();
		}
		
	}
	//FILE LOADER
		private String readFromFile(String filename) {
			String line = "";
			try {
				BufferedReader input = new BufferedReader(
						new InputStreamReader(new FileInputStream(filename))
						);
				try {
					line=input.readLine();
				} catch (IOException e) {
					System.err.println("Exception: interrupted I/O.");
				} finally {
					try {
						input.close();
					} catch (IOException e) {
						System.err.println("I/O exception: unable to close "+filename);
					}
				}
			} catch (FileNotFoundException e) {
				System.err.println("Input file not found.");
			}

			return line;
		}
}

public class Td1Exo13 {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		CreateFile file = new CreateFile();
		file.createFicher();
	}

}
