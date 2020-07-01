package problem11thru20.problem19;

import java.time.DayOfWeek;
import java.time.Month;

import utility.Print;

public class Problem19 {

	public static void main(String args[]) {
		long sundays = howManySundays();
		Print.answer(sundays);
	}

	private static long howManySundays() {
		int count = 0;
		EulerDate date = new EulerDate(1900, 1, Month.JANUARY, DayOfWeek.MONDAY);
		EulerDate ending = new EulerDate(2000, 31, Month.DECEMBER, DayOfWeek.SUNDAY);
		boolean calculating = true;
		while (calculating) {
			log(date);
			if(date.day == 1 && date.dayOfWeek == DayOfWeek.SUNDAY
			   && date.year > 1900) {
				count++;
			}
			date = nextDate(date);
//			calculating = !(date.equals(ending));
			calculating = (date.year < 2001);
		}
		System.out.println("Problem19.log>> " + date);
		return count;
	}

	public static void log(EulerDate date) {
		if (date.day == 1 && date.month.equals(Month.JANUARY)) {
			System.out.println("Problem19.log>> " + date);
		}
	}

	private static EulerDate nextDate(EulerDate date) {
		int newYear = nextYear(date);
		int newDay = nextDay(date);
		Month newMonth = nextMonth(date, newDay);
		DayOfWeek newDayOfWeek = nextDayOfWeek(date);
		EulerDate newDate = new EulerDate(newYear, newDay, newMonth, newDayOfWeek);
		return newDate;
	}

	public static Month nextMonth(EulerDate date, int newDay) {
		if (newDay == 1) {
			switch(date.month) {
			case JANUARY: return Month.FEBRUARY;
			case FEBRUARY: return Month.MARCH;
			case MARCH: return Month.APRIL;
			case APRIL: return Month.MAY;
			case MAY: return Month.JUNE;
			case JUNE: return Month.JULY;
			case JULY: return Month.AUGUST;
			case AUGUST: return Month.SEPTEMBER;
			case SEPTEMBER: return Month.OCTOBER;
			case OCTOBER: return Month.NOVEMBER;
			case NOVEMBER: return Month.DECEMBER;
			case DECEMBER: return Month.JANUARY;
			}
		} else {
			return date.month;
		}
		System.err.println("Problem19.nextMonth>> shouldn't have gotten here....");
		return Month.JANUARY;
	}

	public static int nextDay(EulerDate date) {
		if (date.day < 28) {
			return date.day+1;
		}
		if (thirtyDays(date.month)) {
			if (date.day == 30) {
				return 1;
			} else {
				return date.day+1;
			}
			
		} else if (date.month.equals(Month.FEBRUARY)) {
			if (leapYear(date)) {
				if (date.day == 29) {
					return 1;
				} else {
					return date.day+1;
				}
			} else {
				if (date.day == 28) {
					return 1;
				} else {
					return date.day+1;
				}
			}
		} else {
			//31 days
			if (date.day == 31) {
				return 1;
			} else {
				return date.day+1;
			}
		}
	}

	private static boolean leapYear(EulerDate date) {
		boolean divisibleBy4 = (0 == date.year % 4);
		boolean isACentury = (0 == date.year % 100);
		boolean divisibleBy400 = (0 == date.year % 400);
		boolean leapYear = false;
		int i = 0;
//		if (!divisibleBy4) {
//			leapYear = false;
//			i = 1;
//		} else if (isACentury) {
//			if (divisibleBy400) {
//				leapYear = true;
//				i =2 ;
//			} else {
//				leapYear = false;
//				i = 3;
//			}
//		}
		if (divisibleBy4) {
			if (isACentury) {
				if (divisibleBy400) {
					leapYear = true;
//					i = 1;
				} else {
					leapYear = false;
//					i = 2;
				}
			} else {
				leapYear = true;
//				i = 3;
			}
		} else {
			leapYear = false;
//			i = 4;
		}
//		if (leapYear) {
//			System.out.println(String.format("Problem19.leapYear>> %s IS     a leap year... %s", date.year, i));
//		} else {
//			System.out.println(String.format("Problem19.leapYear>> %s is NOT a leap year... %s", date.year, i));
//		}
		
		return leapYear;
	}

	private static boolean thirtyDays(Month month) {
		return month.equals(Month.SEPTEMBER)
				|| month.equals(Month.APRIL)
				|| month.equals(Month.JUNE)
				|| month.equals(Month.NOVEMBER);
	}

	public static int nextYear(EulerDate date) {
		if (date.day == 31 && date.month.equals(Month.DECEMBER)) {
			return date.year+1;
		} else {
			return date.year;
		}
	}
	
	public static DayOfWeek nextDayOfWeek(EulerDate date) {
		switch(date.dayOfWeek) {
		case SUNDAY: return DayOfWeek.MONDAY;
		case MONDAY: return DayOfWeek.TUESDAY;
		case TUESDAY: return DayOfWeek.WEDNESDAY;
		case WEDNESDAY: return DayOfWeek.THURSDAY;
		case THURSDAY: return DayOfWeek.FRIDAY;
		case FRIDAY: return DayOfWeek.SATURDAY;
		case SATURDAY: return DayOfWeek.SUNDAY;
		}
		System.out.println("Problem19.nextDayOfWeek>> shouldn't have gotten here....");
		return DayOfWeek.SUNDAY;
	}
}
