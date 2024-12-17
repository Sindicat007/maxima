package javaCollectionAPI.task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                "labore labore labore et dolore magna aliqua";

        Scanner scan = new Scanner(System.in);
        TextAnalyzator textAnalyze = new TextAnalyzator(scan.nextLine());
        textAnalyze.startAnalyze();


    }
}
