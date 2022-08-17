import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TheLine {

	private int matchCounter;

	public TheLine() {

		Scanner in = new Scanner(System.in);

		System.out.println("How many people are in the line?");
		int i = in.nextInt();

		ArrayList<Person> peopleInLine = new ArrayList<Person>();

		genLine(i, peopleInLine);

		printBirthdays(i, peopleInLine);

		compareDOB(peopleInLine);

		System.out.println("There are " + matchCounter + " pairs of people that have the same birthday");

		System.out.print("This means that, in a line with " + i + " people, that ");
		System.out.format("%.2f", calcProb(i, matchCounter) * 100);
		System.out.print("% of the people in line share a birthday.");

		// As the number of people in line increases, so do the odd of a match
		// At 366 people there is 100% chance of a match
		// Eventually, there will be more matches than people in line
	}

	private void printBirthdays(int i, ArrayList<Person> peopleInLine) {
		for (int c = 0; c < i; c++) {
			Person temp = new Person();
			GregorianCalendar pnt;
			temp = peopleInLine.get(c);
			pnt = temp.getCal();
			System.out.println("Person  " + (c + 1) + " has a birthday on " + (pnt.get(pnt.MONTH) + 1) + "-"
					+ pnt.get(pnt.DAY_OF_MONTH));
		}
	}

	private void genLine(int i, ArrayList<Person> peopleInLine) {
		for (int c = 0; c < i; c++) {
			Person p = new Person();
			peopleInLine.add(p);

		}
	}

	public void compareDOB(ArrayList array) {
		Person a;
		Person b;

		for (int i = 0; i < array.size(); i++) // using this for to make sure that no pairs will be counted twice
		{
			a = (Person) array.get(i);

			for (int c = (i + 1); c < array.size(); c++)// c = i+1 because there is no need to compare i to itself or
														// any value that came before it
			{
				b = (Person) array.get(c);
				if (a.getDay() == b.getDay()) {

					this.matchCounter++;
				}
			}

		}

	}

	public double calcProb(double elements, double matches) {
		double odds = matches / elements;
		if (odds > 1) { //There reaches a point where multiple persons will match with each other
			return 1.00;//this will eventually lead to more than 100% of people sharing a birthday, which isn't possible
		} else {
			return odds;
		}

	}

}