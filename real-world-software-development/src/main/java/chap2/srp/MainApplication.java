package chap2.srp;

import java.io.IOException;

import chap2.srp.analyzer.BankStatementAnalyzer;
import chap2.srp.parser.BankStatementCSVParser;
import chap2.srp.parser.BankStatementParser;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		
		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
		final BankStatementParser parser = new BankStatementCSVParser();
		
		analyzer.analyze(parser);
	}
}
