package ejnosvn.ChessTravails;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Chessman {

	public Rook(Table t) {
		super(t);
	}

	@Override
	public List<Field> getValidMoves(int startCol, int startRow) {
		List<Field> retFields = new ArrayList<Field>();
		for (int col = startCol + 1; col < 8; col++) {
			if (t.getField(col, startRow).isValid()) {
				retFields.add(t.getField(col, startRow));
			} else {
				break;
			}
		}
		for (int col = startCol - 1; col >= 0; col--) {
			if (t.getField(col, startRow).isValid()) {
				retFields.add(t.getField(col, startRow));
			} else {
				break;
			}
		}

		for (int row = startRow + 1; row < 8; row++) {
			if (t.getField(startCol, row).isValid()) {
				retFields.add(t.getField(startCol, row));
			} else {
				break;
			}
		}
		for (int row = startRow - 1; row >= 0; row--) {
			if (t.getField(startCol, row).isValid()) {
				retFields.add(t.getField(startCol, row));
			} else {
				break;
			}
		}
		return retFields;
	}

	@Override
	public List<Field> getNotBlockedMoves(int startCol, int startRow) {
		List<Field> retFields = new ArrayList<Field>();
		for (int col = startCol + 1; col < 8; col++) {
			if (t.getField(col, startRow).isNotBlocked()) {
				retFields.add(t.getField(col, startRow));
			} else {
				break;
			}
		}
		for (int col = startCol - 1; col >= 0; col--) {
			if (t.getField(col, startRow).isNotBlocked()) {
				retFields.add(t.getField(col, startRow));
			} else {
				break;
			}
		}

		for (int row = startRow + 1; row < 8; row++) {
			if (t.getField(startCol, row).isNotBlocked()) {
				retFields.add(t.getField(startCol, row));
			} else {
				break;
			}
		}
		for (int row = startRow - 1; row >= 0; row--) {
			if (t.getField(startCol, row).isNotBlocked()) {
				retFields.add(t.getField(startCol, row));
			} else {
				break;
			}
		}

		//		System.out.println("GetValidMoves for Rook:"+ t.getField(startCol,startRow).toString() + " :" + retFields.toString());
		return retFields;
	}

}
