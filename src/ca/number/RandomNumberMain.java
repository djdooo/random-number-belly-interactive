package ca.number;
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

	public static void main(String[] args) 
	{
		int[] randomNumber = numberGenerator(100, 20, 10000);
		writeFile( "RandomNumber.txt", randomNumber );
		
		QuickSort sortNumberImpl = new QuickSort();
		sortNumberImpl.sort(randomNumber);
		
		//Arrays provides sort function, easy to use for less amount data
		//Arrays.sort(randomNumber);  
		writeFile( "SortedNumber.txt", randomNumber );
	}
	
	/**
	 * Writing numbers into file
	 * 
	 * @param fileName text file name
	 * @param content data which need to write to file
	 */
	private static void writeFile(String fileName, int[] content)
	{
		Path path = Paths.get(fileName);
		
		try {
			Files.deleteIfExists(path);
			Files.createFile(path);
			
			// Using string builder to append all numbers
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < content.length; i++) 
			{
				// to avoid empty line
				if (i != content.length - 1 ) 
					sb.append(content[i]).append("\n");
				else 
					sb.append(content[i]);
			}
			
			Files.write(path, sb.toString().getBytes());
			
		} catch (IOException e) 
		{
			System.out.println("Error while creating file: " + fileName);
			e.printStackTrace();
		}
	}
	
	/**
	 * Generate random numbers
	 * 
	 * @param numbers how many numbers need to be generated
	 * @param min minimum random number
	 * @param max maximum random number 
	 * @return
	 */
	private static int[] numberGenerator(Integer numbers, Integer min, Integer max) 
	{
		ThreadLocalRandom current = ThreadLocalRandom.current();
		int[] list = new int[numbers];
		for (int i = 0; i < list.length; i++) 
		{
			list[i] = current.nextInt(min, max + 1);
		}
		return list;
	}
	
}
