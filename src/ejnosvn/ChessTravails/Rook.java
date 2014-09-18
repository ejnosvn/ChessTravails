package ejnosvn.ChessTravails;

import java.util.List;
import java.util.ArrayList;

public class Rook extends Chessman{

	public Rook(Table t) {
		super(t);
	}

	@Override
	public List<Field> getValidMoves(int startCol, int startRow, boolean blockedOnly) {
		List<Field> retFields = new ArrayList<Field>();
		for (int col = startCol+1; col < 8; col++) {
			if( (!blockedOnly && t.getField(col,startRow).isValid())
				||
			    (blockedOnly && t.getField(col,startRow).isNotBlocked())){
				retFields.add(t.getField(col, startRow));
			} else {
				break;
			}
		}
		for (int col = startCol-1; col >= 0; col--) {
			if( (!blockedOnly && t.getField(col,startRow).isValid())
			    ||
			    (blockedOnly && t.getField(col,startRow).isNotBlocked())){
				retFields.add(t.getField(col, startRow));
			} else {
				break;
			}
		}
		
		for (int row = startRow+1; row < 8; row++) {
			if( (!blockedOnly && t.getField(startCol, row).isValid())
				||
 			    (blockedOnly && t.getField(startCol, row).isNotBlocked())){
				retFields.add(t.getField(startCol, row));
			} else {
				break;
			}
		}
		for (int row = startRow-1; row >= 0 ; row--) {
			if( (!blockedOnly && t.getField(startCol, row).isValid())
				||
 			    (blockedOnly && t.getField(startCol, row).isNotBlocked())){
				retFields.add(t.getField(startCol, row));
			} else {
				break;
			}
		}

		System.out.println("GetValidMoves for Rook:"+ t.getField(startCol,startRow).toString() + " :" + retFields.toString());
		return retFields;
	}
	
}
