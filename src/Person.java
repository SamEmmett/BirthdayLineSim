import java.util.GregorianCalendar;

public class Person {

	private GregorianCalendar dob = null;
	
	public Person(){
		
		
		genBirthday();
		
	}
	
	
	public void genBirthday() {
		
		GregorianCalendar cal = new GregorianCalendar();
		
		//int year = randVal(1910, 2021); //randomly generates a number for the year
		
		// cal.set(cal.YEAR, year);
		
		// year is not really needed as the situation is looking for a person who is born on the same month and day as another//////////////////////////
		
		int day = randVal(1, cal.getActualMaximum(cal.DAY_OF_YEAR)); //Randomly generates a value for the day and then that value will be turned into a month and day
		
		cal.set(cal.DAY_OF_YEAR, day);
		
		
		this.dob = cal;
	}
	
	public int randVal(int start, int end) {
		
		return start + (int) Math.round(Math.random() * (end - start));
		//creates a value by multiplying a random number with the difference between end and start
		//then rounds that value
		//the rounded value is then added to the start value
	}
	
	public GregorianCalendar getCal() {
		
		return this.dob;		
	}
	
	public int getDay() {
		
		return this.dob.get(dob.DAY_OF_YEAR);
		
	}
}
