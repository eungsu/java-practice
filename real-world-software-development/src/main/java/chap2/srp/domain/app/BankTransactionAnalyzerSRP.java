package chap2.srp.domain.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import chap2.srp.domain.BankTransaction;
import chap2.srp.parser.BankStatementCSVParser;

public class BankTransactionAnalyzerSRP {

	static final String RESOURCES = "src/main/resources/bank-data-simple.csv";
	
	public static void main(String[] args) throws IOException {
		final BankStatementCSVParser parser = new BankStatementCSVParser();
		
		final Path path = Paths.get(RESOURCES);
		final List<String> lines = Files.readAllLines(path);
		final List<BankTransaction> bankTransactions = parser.parseLinesFromCSV(lines);
		
		System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
		System.out.println("The total for all transactions in January is " + selectInMonth(bankTransactions, Month.JANUARY).stream().mapToDouble(bankTransaction -> bankTransaction.getAmount()).sum());
	}
	
	public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		double total = 0.0;
		for (final BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}
	
	public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
		final List<BankTransaction> bankTransactionsMonth = new ArrayList<>();
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				bankTransactionsMonth.add(bankTransaction);
			}
		}
		return bankTransactionsMonth;
	}
}
