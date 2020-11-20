
public class FileReaderDemo {

	public static void main(String[] args) {
		int count;
		String result;
		try {
			FileReader fileReader = new FileReader();
			result = fileReader.readFile();
		
			// Count number of words of given text file
			count = new WordCounter().countWords(result);
			System.out.println("Number of words in text file " + count);
			
			// Print average time to read given text file
			ReadTimeFactory readTime = new ReadTimeFactory();
			System.out.println(
					"Read time of average person " + readTime.getReadTime("average").calculateTime(count) + " Minutes");
			System.out.println(
					"Read time of executive " + readTime.getReadTime("executive").calculateTime(count) + " Minutes");
			System.out.println("Read time of child " + readTime.getReadTime("child").calculateTime(count) + " Minutes");
		
			// Command line
			CommandLineReader commandLineReader = new CommandLineReader();
			result = commandLineReader.readCommandLine(args);
			
			System.out.println("For Command line input");
			count = new WordCounter().countWords(result);
			System.out.println("Number of words in text file " + count);

			// Print average time to read given argument
			System.out.println(
					"Read time of average person " + readTime.getReadTime("average").calculateTime(count) + " Minutes");
			System.out.println(
					"Read time of executive " + readTime.getReadTime("executive").calculateTime(count) + " Minutes");
			System.out.println("Read time of child " + readTime.getReadTime("child").calculateTime(count) + " Minutes");
		} catch (NullPointerException e) {
			System.out.println("NullPointerException..");
		}

	}

}
