
/**
 * @author NicolePuente - npuente
 * CIS175 - Spring 2024
 * Jan 18, 2024
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// create new instance of Scanner object and GradeBook object
		Scanner scan = new Scanner(System.in);
		GradeBook scoresArr = new GradeBook();

		ArrayList<Integer> userScoresArr = new ArrayList<Integer>();
		String testName;
		int numOfTest;

		// prompt user for the name of test and the number of scores they would like to
		// enter
		System.out.println("Enter the name of the test: ");
		testName = scan.next();

		System.out.println("Enter the number of scores you would like enter: ");
		numOfTest = scan.nextInt();

		// this for loop will loop however many times the user entered how many scores
		// they want to see and will prompt for next score
		for (int i = 0; i < numOfTest; i++) {
			System.out.println("Enter a score: ");
			userScoresArr.add(scan.nextInt());
		}

		// this section will set the test name to the scoresArr object and add the
		// scores to it
		scoresArr.setTestName(testName);
		scoresArr.setUserScoresArr(userScoresArr);

		// call the setLetterGrades method to determine which letter grade goes with
		// which number score
		scoresArr.setLetterGrades();

		// close the scanner
		scan.close();

	}

}
