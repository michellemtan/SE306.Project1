package se306;

import org.junit.Before;
import org.junit.Test;
import se306.exceptions.InvalidInputException;
import se306.input.CommandLineParser;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class CommandLineParserTest {
    CommandLineParser cliArgumentParser;

    @Before
    public void init() {

    }

    /**
     * Test that a invalid input exception is not thrown with a valid command line input
     */
    @Test
    public void parseTwoArgsValid() {
        String[] input = new String[]{"hi.dot", "2"};
        cliArgumentParser = CommandLineParser.getInstance();
        try {
            cliArgumentParser.parseCommandLineArguments(input);
        } catch (InvalidInputException e) {
            fail();
        }
    }

    @Test
    public void parseSecondArgsNotNumber() throws InvalidInputException {
        String[] input = new String[]{"hi.dot", "x"};
        cliArgumentParser = CommandLineParser.getInstance();
        try {
            cliArgumentParser.parseCommandLineArguments(input);
        } catch (NumberFormatException e) {
            assertEquals("Please enter an integer for the number of processors to be used", e.getMessage());
        }
    }

    @Test
    public void parseNoArgs() {
        String[] input = new String[0];
        cliArgumentParser = CommandLineParser.getInstance();
        try {
            cliArgumentParser.parseCommandLineArguments(input);
        } catch (InvalidInputException e) {
            assertEquals("Please enter the .dot input file AND number of processors to be used", e.getMessage());
        }
    }

    @Test
    public void parseNoProcessors() {
        String[] input = new String[]{"hi.dot", "0"};
        cliArgumentParser = CommandLineParser.getInstance();
        try {
            cliArgumentParser.parseCommandLineArguments(input);
        } catch (InvalidInputException e) {
            assertEquals("Please enter a valid number of processors (at least 1)", e.getMessage());
        }
    }

    @Test
    public void parseIncorrectCores() {
        String[] input = new String[]{"hi.dot", "2", "-p", "0"};
        cliArgumentParser = CommandLineParser.getInstance();
        try {
            cliArgumentParser.parseCommandLineArguments(input);
        } catch (InvalidInputException e) {
            assertEquals("Please enter a valid number of cores (processors) for paralellising the search", e.getMessage());
        }
    }

    @Test
    public void parseNoDotFile(){
        String[] input = new String[]{"hi", "2", "-p", "2"};
        cliArgumentParser = CommandLineParser.getInstance();
        try {
            cliArgumentParser.parseCommandLineArguments(input);
        } catch (InvalidInputException e) {
            assertEquals("Please enter a file with the .dot extension", e.getMessage());
        }
    }
}
