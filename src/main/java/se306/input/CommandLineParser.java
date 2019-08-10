package se306.input;

import com.google.devtools.common.options.OptionsParser;
import se306.exceptions.InvalidInputException;

import java.util.Collections;

/**
 * Singleton class for parsing command line inputs
 */
public class CommandLineParser {
	private static CommandLineParser commandLineParser_instance = null;
	private String inputFileName;
	private String outputFileName;
	private int numberOfProcesses;

	public int getNumberOfProcesses() {
		return numberOfProcesses;
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	/**
	 * Private constructor only called by this class
	 */
	private CommandLineParser()
	{
		numberOfProcesses = 1;
		outputFileName = "output.dot";
	}

	/**
	 * Static method to return single instance of singleton class
	 * @return
	 */
	public static CommandLineParser getInstance()
	{
		if (commandLineParser_instance == null)
			commandLineParser_instance = new CommandLineParser();

		return commandLineParser_instance;
	}

	/**
	 * Parse all command line arguments
	 * @param input
	 */
	public void parseCommandLineArguments(String[] input) throws InvalidInputException {
		OptionsParser parser = OptionsParser.newOptionsParser(CommandLineArguments.class);
		parser.parseAndExitUponError(input);
		CommandLineArguments options = parser.getOptions(CommandLineArguments.class);
		if (options.numberOfCores < 0 ) {
			printUsage(parser);
            System.out.println("Please enter a valid number of cores to be used to paralellise this search.");
            throw(new InvalidInputException());
		}

		try {
            numberOfProcesses = Integer.parseInt(input[1]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
		System.out.println(numberOfProcesses);
		inputFileName = "/" + input[0];
		System.out.println(inputFileName);
		outputFileName = options.outputFile;
		System.out.println(outputFileName);

	}

	private static void printUsage(OptionsParser parser) {
		System.out.println("Usage: java -jar scheduler.jar INPUT.dot P [OPTIONS]");
		System.out.println(parser.describeOptions(Collections.<String, String>emptyMap(),
				OptionsParser.HelpVerbosity.LONG));
	}
}
