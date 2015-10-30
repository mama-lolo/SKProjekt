package algorythms;

import java.util.Vector;

public class BubbleSort extends AbstractSortingAlgorythm {
	
	
	public void sort (Comparable[] data) {
		 int n = data.length;
				  do{
				    int newn = 1;
				    for (int i=0; i<n-1; ++i){
				      if (data[i].compareTo(data[i+1])>0){
				        swap(data,i, i+1);
				        newn = i+1;
				      }
				    } 
				    n = newn;
				  } while (n > 1);
	}
	
	public void sort(Comparable[] data,Vector<Comparable[]> progress){
		int n = data.length;
		  do{
		    int newn = 1;
		    for (int i=0; i<n-1; ++i){
		      if (data[i].compareTo(data[i+1])>0){
		        swap(data,i, i+1);
		        progress.add(data.clone());
		        newn = i+1;
		      }
		    } 
		    n = newn;
		  } while (n > 1);
	}
	

}