import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Generate and sort a million random numbers, write to files
 * 
 * @author Chen Wang
 *
 */
public class RandomNumberMain {

	public static void main(String[] args) {
		
		// Write million random number to file
		try {
			BufferedWriter randomWriter=Files.newBufferedWriter(createFile("RandomNumber.txt"));
			
			int[] millionNumbers = numberGenerator(10,1,100);
			for (Integer integer : millionNumbers) {
				randomWriter.write(integer + "\n");
			}
			randomWriter.flush();
			randomWriter.close();
		} catch (IOException e) {
			System.out.println("Random number file created unsecussfully.");
			e.printStackTrace();
		}
		
		// Write million sorted number to file
		try {
			BufferedWriter sortedWriter=Files.newBufferedWriter(createFile("SortedNumber.txt"));
			int[] millionNumbers = numberGenerator(1000,-100,1000);
			
			SortNumbers.sort(millionNumbers);
			
			for (Integer integer : millionNumbers) {
				sortedWriter.write(integer + "\n");
			}
			
			sortedWriter.flush();
			sortedWriter.close();
		} catch (IOException e) {
			System.out.println("Sorted number file created unsecussfully.");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Create text file 
	 *  
	 * @param fileName
	 * @return Path used to create input stream
	 * @throws IOException
	 */
	private static Path createFile(String fileName) throws IOException
	{
		Path path = Paths.get(fileName);
		Files.deleteIfExists(path);
		Files.createFile(path);
		return path;
	}
	
	/**
	 * Generate random numbers
	 * 
	 * @param numbers how many numbers need to be generated
	 * @param min minimum random number
	 * @param max maximum random number 
	 * @return
	 */
	private static int[] numberGenerator(Integer numbers, Integer min, Integer max) {
		int[] list = new int[numbers];
		for (int i = 0; i < list.length; i++) {
			list[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
		}
		return list;
	}
	
}
