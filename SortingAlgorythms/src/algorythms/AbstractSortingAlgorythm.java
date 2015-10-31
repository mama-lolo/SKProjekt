package algorythms;

import java.util.concurrent.LinkedBlockingDeque;

import util.DataSet;

public abstract class AbstractSortingAlgorythm {
	
	public abstract void sort(Comparable[] data);
	
	public abstract void sort(Comparable[] data,LinkedBlockingDeque<DataSet> progress);
	
	protected static void swap(Comparable[] data,int index1, int index2){
		Comparable local = data[index1];
		data[index1]=data[index2];
		data[index2]=local;
		
	}

}
