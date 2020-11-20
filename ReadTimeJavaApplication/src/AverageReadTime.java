
public class AverageReadTime implements ReadTime {

	public double calculateTime(int words) {
		double time = 0;
		try {
			time = Double.valueOf(words) / 200;
		} catch (ArithmeticException e) {
			System.out.println("Can't be divided by Zero" + e);
		}
		return Math.round(time * 100.0) / 100.0;
	}
}
