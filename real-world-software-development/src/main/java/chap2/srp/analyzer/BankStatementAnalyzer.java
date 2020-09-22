package chap2.srp.analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import chap2.srp.domain.BankTransaction;
import chap2.srp.parser.BankStatementParser;
import chap2.srp.processor.BankStatementProcessor;

public class BankStatementAnalyzer {

	private static final String RESOURCES = "src/main/resources/bank-data-simple.csv";
	
	public void analyze(final BankStatementParser bankStatementParser) throws IOException {
	
		final Path path = Paths.get(RESOURCES);
		final List<String> lines = Files.readAllLines(path);
		
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
		final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
		
		collectSummary(bankStatementProcessor);
	}
	
	private void collectSummary(BankStatementProcessor bankStatementProcessor) {
		System.out.println("The total for all transactions is " 
				+ bankStatementProcessor.calculateTotalAmount());
		
		System.out.println("The total for transactions in January is " 
				+ bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
		System.out.println("The total for transactions in February is " 
				+ bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		
		System.out.println("The total salary received is "
				+ bankStatementProcessor.calculateTotalForCategory("Salary"));
	}
}
