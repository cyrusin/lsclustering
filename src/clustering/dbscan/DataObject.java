package clustering.dbscan;

public class DataObject {
	private double[] value;
	private int cid=0;
	private boolean isVisited=false;

	public double[] getVector() {
		// TODO Auto-generated method stub
		return value;
	}

	public boolean isVisited() {
		// TODO Auto-generated method stub
		return isVisited;
	}

	public void setVisited(boolean b) {
		// TODO Auto-generated method stub
		isVisited=b;
		
	}

	public int getCid() {
		// TODO Auto-generated method stub
		return cid;
	}

	public void setCid(int i) {
		// TODO Auto-generated method stub
		cid=i;
	}

}
