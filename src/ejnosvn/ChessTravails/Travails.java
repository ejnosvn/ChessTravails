package ejnosvn.ChessTravails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Travails {
	Chessman chessman = null;
	Table t = null;

	public Travails() {
		t = new Table();
	}

	public String[] solve(final String[] fields) {
		System.out.println("Start fields: " + Arrays.toString(fields));

		for (int i = 0; i < fields.length; i++) {
			t.storeField(i, fields[i]);
		}

		solveTable(Field.START);
		t.writeTableToConsole();
		String[] result = null;
		result = getSolution(result);
		System.out.println("Result fields: " + result);
		return result;
	}

	public boolean solveTable(int startFrom) {
		int whichStep = startFrom;
		whichStep++;
		boolean ret = false;
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++) {
				if (t.getField(i, j).getValue() == startFrom) {
					List<Field> fields = chessman.getValidMoves(i, j, new CheckIsNotBlockedCommand());
					for (Field field : fields) {
						if (ret == false) {
							ret = t.setField(field, whichStep);
						}
					}
				}
			}
		}
		if (whichStep < 64 && t.hasTableUnknownField() && ret == false) {
			return solveTable(whichStep);
		}
		return ret;
	}

	private String[] getSolution(String[] result) {
		List<String> results = new ArrayList<String>();

		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++) {
				if (t.getField(i, j).isEndField() == true) {
					results.add(t.getField(i, j).toString());
					results = getValidMove(results, i, j);
				}
			}
		}
		//System.out.println("Results: " + results);
		if (results.size() > 0) {
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

	private List<String> getValidMove(List<String> results, int i, int j) {
		List<Field> fields = chessman.getValidMoves(i, j, new CheckIsValidCommand());
		int smallestFieldNearby = Field.NOT_VISITED;
		Field smallestField = null;
		boolean notReached = true;
		for (Field field : fields) {
			field.reachedInStepNumber = field.getValue();
			if (field.isStartField()) {
				notReached = false;
			}
			//System.out.println("Mi az ertek:: " + field.getValue());
			//System.out.println("Mi az smallestFieldNearby:: " + smallestFieldNearby);
			if (field.getValue() > 0
					&& (field.getValue() < smallestFieldNearby || smallestFieldNearby == Field.NOT_VISITED)) {
				smallestFieldNearby = field.getValue();
				smallestField = field;
			}
		}

		if (notReached && smallestField != null) {
			System.out.println("Erre megyunk tovabb: " + smallestField);
			results.add(0, smallestField.toString());
			results = getValidMove(results, smallestField.column, smallestField.row);
		} else if (notReached && smallestField == null) {
			results.clear();
		}

		return results;
	}

}
