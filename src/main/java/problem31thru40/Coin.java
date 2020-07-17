package problem31thru40;

public class Coin {
	double unit;
	String type;
	public Coin(double u, String t) {
		unit = u;
		type = t;
	}
	public Coin convert(String newType) {
		if (type.equals(newType)) {
			return this;
		} else if ("pence".equals(newType)) {
			//convert from pound to pence
			double newUnit = unit * 100;
			return new Coin(newUnit, "pence");
		} else if ("pound".equals(newType)) {
			//convert from pence to pound
			double newUnit = unit / 100;
			return new Coin(newUnit, "pound");
		}
		return null;
	}
}
