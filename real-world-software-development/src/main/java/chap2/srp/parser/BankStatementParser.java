package chap2.srp.parser;

import java.util.List;

import chap2.srp.domain.BankTransaction;

public interface BankStatementParser {

	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);
}
