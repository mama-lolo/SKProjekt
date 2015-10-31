package util;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * DataSet is one arraystate of the 
 * @author Malte
 *
 */
public class DataSet {
	public Object[]data;
	public LinkedBlockingDeque<Object> changePositions;
	
	public DataSet(Object[]input){
		data=input;
		changePositions= new LinkedBlockingDeque<>();
	}
	
	public DataSet clone(){
		DataSet clone = new DataSet(data.clone());
		clone.changePositions=changePositions;
		return clone;
	}
}
