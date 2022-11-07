/**
 * This class implements the Singleton pattern. It has the private constructor.
 */

public class Evaluator {
	private static Evaluator _instance;

	private Evaluator() {
	};

	public static Evaluator getEvaluator() {
		if (_instance == null)
			_instance = new Evaluator();
		return _instance;
	}

	public int findAvg() {
		DataSource ds = DataSource.getDataSource();
		int[] data = ds.getData();
		int sum = 0;
		for (int num : data) {
			sum += num;
		}
		return sum / data.length;
	}
}
