public abstract class Observable {
	private Observer obs1;

	public Observer getObs1() {
		return obs1;
	}

	public void setObs1(Observer o) {
		this.obs1 = o;
	}
	
	public abstract void notifying();
}
