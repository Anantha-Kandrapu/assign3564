/**
 * This class is a part of the Observer pattern. DataSource acts as the observable.
 */

public class DataSource extends Observable {
	private static DataSource d;
	int[] points = new int[25];

	public static DataSource getDataSource() {
		if (d == null)
			d = new DataSource();
		return d;
	}

	private DataSource() {
	}

	// Generates random points and stores it in an array. Calls the notify method to notify the observers.
	
	public void setData() {
		for (int i = 0; i < 25; i++) {
			points[i] = (int) (Math.random() * 450) + 10;
		}
		notifying();
	}

	public int[] getData() {
		return points;
	}

	@Override
	public void notifying() {
		this.getObs1().update(points);
	}
}
