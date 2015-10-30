package algorythms;

import java.util.Vector;

public class GnomeSort extends AbstractSortingAlgorythm {

	@Override
	public void sort(Comparable[] data) {
		for(int i = 1; i<data.length;i++){
			int j = i;
			while(data[j].compareTo(data[j-1])<0){
				swap(data,j,j-1);
				if(j==1){
					break;
				}else{j--;}	
			}
		}
		
	}

	@Override
	public void sort(Comparable[] data, Vector<Comparable[]> progress) {

		for(int i = 1; i<data.length;i++){
			int j = i;
			while(data[j].compareTo(data[j-1])<0){
				swap(data,j,j-1);
				
				progress.addElement(data.clone());
				
				if(j==1){
					break;
				}else{j--;}	
			}
		}
	}

}
