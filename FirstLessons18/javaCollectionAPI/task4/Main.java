package javaCollectionAPI.task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TextAnalyzator textAnalyze = new TextAnalyzator(scan.nextLine());
        textAnalyze.startAnalyze();
    }
}
