package se306.visualisation.backend;

import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;
import se306.input.CommandLineParser;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphParser {

	public static int totalNodes = 0, totalEdges = 0;
	public static MutableGraph g;

	public void parseGraph() {
		try {
			CommandLineParser parser = CommandLineParser.getInstance();
			String s = parser.getInputFileName();
			InputStreamReader isr = new FileReader(parser.getInputFileName());
			InputStream inputStream = new FileInputStream(s);

			getNumberOfNodesAndEdges(isr);
			g = Parser.read(inputStream);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void getNumberOfNodesAndEdges(InputStreamReader isr) {
		BufferedReader buffRead = new BufferedReader(isr);

		try {
			String line;
			buffRead.readLine();
			while ((line = buffRead.readLine()) != null) {
				String end = line.substring(0, 1);

				// Stop reading once it reaches end of file
				if (end.equalsIgnoreCase("}")) {
					break;
				}
				// If the line is not a line that includes a node or an edge
				Pattern p = Pattern.compile(".*\\[Weight=.*];");
				Matcher m = p.matcher(line);
				if (!m.matches()) {
					continue;
				}

				if (line.indexOf("->") == -1) { // Handle nodes
					totalNodes++;
				} else {
					totalEdges++;
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
