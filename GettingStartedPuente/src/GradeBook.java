
/**
 * @author NicolePuente - npuente
 * CIS175 - Spring 2024
 * Jan 20, 2024
 */

import java.util.ArrayList;

public class GradeBook {
	public String testName;
	public ArrayList<Integer> userScoresArr = new ArrayList<Integer>();

	/**
	 * @param testName
	 * @param userScores
	 */
	public GradeBook(String testName, ArrayList<Integer> userScoresArr) {
		this.testName = testName;
		this.userScoresArr = userScoresArr;
	}

	// non default no arg constructor
	public GradeBook() {

	}

	/**
	 * @return the testName
	 */
	protected String getTestName() {
		return testName;
	}

	/**
	 * @param testName the testName to set
	 */
	protected void setTestName(String testName) {
		this.testName = testName;
	}

	/**
	 * @return the userScoresArr
	 */
	protected ArrayList<Integer> getUserScoresArr() {
		return userScoresArr;
	}

	/**
	 * @param userScoresArr the userScoresArr to set
	 */
	protected void setUserScoresArr(ArrayList<Integer> userScoresArr) {
		this.userScoresArr = userScoresArr;
	}

	// method that will set the letter grades that corresponds to the scores
	// arraylist
	public void setLetterGrades() {
		System.out.println("Test Name: " + getTestName() + "\nScore -------- Grade\n");

		for (int i = 0; i < userScoresArr.size(); i++) {
			char letter;
			if (userScoresArr.get(i) >= 90) {
				letter = 'A';
			} else if (userScoresArr.get(i) >= 80) {
				letter = 'B';
			} else if (userScoresArr.get(i) >= 70) {
				letter = 'C';
			} else if (userScoresArr.get(i) >= 60) {
				letter = 'D';
			} else {
				letter = 'F';
			}
			System.out.println(" " + userScoresArr.get(i) + "-------- " + letter);
		}

	}

}
