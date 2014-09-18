package ejnosvn.ChessTravails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Travails {
	Chessman chessman = null;
	Table t = null;
	
	public Travails(){
		t = new Table();
	}
	
	public String[] solve( final String[] fields){
		System.out.println("Start fields: " + Arrays.toString(fields));
		
		for (int i = 0;  i< fields.length; i++) {
			t.storeField(i,fields[i]);
		}
		
		solveTable(Table.START_FIELD);
		t.writeTableToConsole();
		String[] result = null;
		result = getSolution(result);
		return result;
	}

	public boolean solveTable(int startFrom) {
		int whichStep = startFrom;
		whichStep++;
		boolean ret = false;
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++) {
				if(t.getValueOfField(i,j) == startFrom){
//					if(ret == false){
//						//TODO ez itt rossz, csak bastyara megy, knightra nem
//					  ret = t.setRow(i, j, whichStep);
//					}
//					if(ret == false){
//					  ret = t.setColumn(i, j, whichStep);
//					}
					List<Field> fields = chessman.getValidMoves(i, j, true);
					for (Field field : fields) {
						if(ret == false){
							System.out.println("Milyen fieldet setelunk:: " + field.toString());
							ret = t.setField(field, whichStep);
						}
					}
				}
			}
		}
		if( whichStep < 64 && t.hasTableUnknownField() && ret == false){
		  return solveTable(whichStep);
		}
		return ret;
	}
	
	private String[] getSolution(String[] result) {
		List<String> results = new ArrayList<String>();
		
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++) {
				if(t.getField(i,j).endField == true){
					results.add(t.getField(i,j).toString());
					results = getValidMove( results, i, j);
				}
			}
		}
		//System.out.println("Results: " + results);
		if(results.size() > 0){
			result = new String[results.size()];
			int i = 0;
			for (String string : results) {
				result[i++] = string;
			}
		} else {
			result = null;
		}
		System.out.println("Result: " + Arrays.toString(result));
		return result;
	}

	private List<String> getValidMove( List<String> results, int i, int j) {
		List<Field> fields = chessman.getValidMoves(i, j, false);
		int smallestFieldNearby = Table.NOTSEENYET_FIELD;
		Field smallestField = null;
		boolean notReached = true;
		for (Field field : fields) {
			//System.out.println("Ezek kozul: " + field);
			field.value = t.getValueOfField(field);
			if( t.getValueOfField(field) == Table.START_FIELD ) {
				notReached = false;
			}
			//System.out.println("Mi az ertek:: " + t.getValueOfField(field));
			//System.out.println("Mi az smallestFieldNearby:: " + smallestFieldNearby);
			if( t.getValueOfField(field) > 0 &&
				(t.getValueOfField(field) < smallestFieldNearby || smallestFieldNearby == Table.NOTSEENYET_FIELD)){
				smallestFieldNearby = t.getValueOfField(field);
				smallestField = field;
			}
		}
		
		if(notReached && smallestField != null){
			System.out.println("Erre megyunk tovabb: " + smallestField);
			results.add(0, smallestField.toString());
			results = getValidMove( results, smallestField.i, smallestField.j);
		} else if(notReached && smallestField == null){
			results.clear();
		}
		
		return results;
	}

}
