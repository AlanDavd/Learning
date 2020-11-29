package com.company.bankAnalyzer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
        final Exporter exporter = new HtmlExporter();
        bankStatementAnalyzer.analyze("bank-data.csv", bankStatementParser, exporter);
    }
}
