package clustering.dbscan;

import java.math.*;

public class Global {

	public static double calDist(double[] arr1, double[] arr2, int len) {
		// TODO Auto-generated method stub
		
		double dist=0.0;
		double sum=0.0;
		//double result=0.0;
		if(arr1.length!=arr2.length){
			System.out.println("Error:check your data again!");
			return dist;
			
		}else{
			for(int i=0;i<len;i++){
				sum=sum+Math.pow((arr1[i]-arr2[i]),len);
			}
			
		}
		
		dist=Math.pow(sum, 1/len);
		return dist;
	}

}
