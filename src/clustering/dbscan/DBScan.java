package clustering.dbscan;

import java.util.*;

public class DBScan {
	
	double eps;
	int minPts;
	
	public void setEps(double e){
		eps=e;
	}
	public void setMinPts(int i){
		minPts=i;
	}
	
	public Vector<DataObject> getNeighbors(DataObject p,ArrayList<DataObject> objects){
		Vector<DataObject> neighbors=new Vector<DataObject>();
		Iterator<DataObject> iter=objects.iterator();
		while(iter.hasNext()){
			DataObject q=(DataObject) iter.next();
			double[] arr1=p.getVector();
			double[] arr2=q.getVector();
			int len=arr1.length;
			if(Global.calDist(arr1,arr2,len)<=eps){
//			if(Global.calEuraDist(arr1,arr2,len)<=Eps){
//				if(Global.calCityBlockDist(arr1,arr2,len)<=Eps){
				
				neighbors.add(q);
			}
		}
		return neighbors;
	}

	public int dbScan(ArrayList<DataObject> objects){
		int clusterID=0;
		boolean AllVisited=false;
		while(!AllVisited){
			Iterator<DataObject> iter=objects.iterator();
			while(iter.hasNext()){
				DataObject p=iter.next();
				if(p.isVisited())
					continue;
				AllVisited=false;
				p.setVisited(true);
				Vector<DataObject> neighbors=getNeighbors(p,objects);
				if(neighbors.size()<minPts){
					if(p.getCid()<=0)
						p.setCid(-1);
					}
					else{
						if(p.getCid()<=0){
							clusterID++;
							expandCluster(p,neighbors,clusterID,objects);
						}
						else{
							int iid=p.getCid();
							expandCluster(p,neighbors,iid,objects);
						}
					}
					AllVisited=true;
				}
			}
		
		return clusterID;
	}
	
	

	private void expandCluster(DataObject p,Vector<DataObject> neighbors,
			int clusterID,ArrayList<DataObject> objects){
		p.setCid(clusterID);
		Iterator<DataObject> iter=neighbors.iterator();
		while(iter.hasNext()){
			DataObject q=iter.next();
		
				
				if(!q.isVisited()){
					q.setVisited(true);
					Vector<DataObject> qneighbors=getNeighbors(q,objects);
					if(qneighbors.size()>=minPts){
						Iterator<DataObject> it=qneighbors.iterator();
						while(it.hasNext()){
							DataObject no=it.next();
							if(no.getCid()<=0)
								no.setCid(clusterID);
						}
					}
				}
				if(q.getCid()<=0){
					q.setCid(clusterID);
				}
			}
			
		}
	}

