import java.util.*;

public class EmployeeCatalog {

	public LinkedList<Employee> developers;

	public EmployeeCatalog(int catalogSize) {

		// initialize a linked list to store employee records
		developers = new LinkedList<Employee>();

		// generate random employee data
		for (int i = 0; i < catalogSize; i++) {

			// create 1000 random employees
			Employee x = new Employee(i, true);
			developers.add(x);
		}
	}

	public Employee[] sortByValue() {
		// value is calculated by hoursBilled * a quality modifier
		Employee[] returnArray = new Employee[developers.size()];
		int lastPosition = 0;
		for (Employee e : developers) {
			double thisValue = (double) e.getHoursBilled() * ((double) 1 / ((int) e.getQualityGrade() - 96));
			e.setValueRanking(thisValue);
			returnArray[lastPosition] = e;
			for (int r = lastPosition; r > 0; r--) {
				// if right is greater than left...
				if (returnArray[r].getValueRanking() > returnArray[r - 1].getValueRanking()) {
					// store left
					Employee emp = returnArray[r - 1];
					// copy right into left
					returnArray[r - 1] = returnArray[r];
					// copy stored left into right
					returnArray[r] = emp;
				}
			}
			lastPosition++;
		}
		return returnArray;
	}

	public int averageLinesOfCode() {
		// compute the average of all the developer lines of code values
		int totalLines = 0;
		for (Employee e : developers) {
			totalLines += e.getLinesOfCode();
		}
		// it is OK we are dropping the decimal
		return totalLines / developers.size();
	}

	public void setQualityGrade() {
		// developers get a grade based on a percentage of bugs per lines of code
		for (Employee e : developers) {
			double percentQuality = (double) (e.getLinesOfCode() - e.getBugCount()) / e.getLinesOfCode();
			char grade = 'f'; // default case
			if (percentQuality >= 0.9) {
				grade = 'a';
			} else if (percentQuality >= 0.8) {
				grade = 'b';
			} else if (percentQuality >= 0.7) {
				grade = 'c';
			} else if (percentQuality >= 0.6) {
				grade = 'd';
			}
			e.setQualityGrade(grade);
		}
	}

	public void setQuantityRankings() {

		for (Employee e : developers) {
			// quantity ranking is a function of lines of code per hour of billed time
			// compute the efficiency of this developer, then count how many developers
			// were more productive
			int rank = 0;
			double efficiency = e.getLinesOfCode() / e.getHoursBilled();
			for (Employee f : developers) {
				if (f.getEmployeeId() != e.getEmployeeId()) // don't compare this one!
				{
					double fEfficiency = f.getLinesOfCode() / f.getHoursBilled();
					if (fEfficiency < efficiency) {
						rank++;
					}
				}
			}
			e.setQuantityRanking(rank);
		}
	}

}