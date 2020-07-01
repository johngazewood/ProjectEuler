package problem11thru20.problem19;

import java.time.DayOfWeek;
import java.time.Month;

public class EulerDate {
	int year;
	int day;
	Month month;
	DayOfWeek dayOfWeek;
	public EulerDate(int year, int day, Month month, DayOfWeek dayOfWeek) {
		super();
		this.year = year;
		this.day = day;
		this.month = month;
		this.dayOfWeek = dayOfWeek;
	}
	@Override
	public String toString() {
		return "EulerDate [year=" + year + ", day=" + day + ", month=" + month + ", dayOfWeek=" + dayOfWeek + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EulerDate other = (EulerDate) obj;
		if (day != other.day)
			return false;
		if (dayOfWeek != other.dayOfWeek)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
}
