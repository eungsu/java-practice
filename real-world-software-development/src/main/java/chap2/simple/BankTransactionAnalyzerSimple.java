package chap2.simple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class BankTransactionAnalyzerSimple {

	private static final String RESOURCES = "src/main/resources/bank-data-simple.csv";

	public static void main(String[] args) throws IOException {
		
		final Path path = Paths.get(RESOURCES);
		final List<String> lines = Files.readAllLines(path);
		
		double total = 0.0;
		double totalByMonth = 0;
		final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.KOREA);
		for (final String line : lines) {
			final String[] columns = line.split(",");
			final double amount = Double.parseDouble(columns[1]);
			total += amount;
			
			final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
			if (date.getMonth() == Month.JANUARY) {
				totalByMonth += amount;
			}
		}
		
		System.out.println("The total for all transactions is " + total);
		System.out.println("The total for all transactions in January is " + totalByMonth);
	}
}
