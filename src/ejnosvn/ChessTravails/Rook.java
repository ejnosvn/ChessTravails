package ejnosvn.ChessTravails;

import java.util.List;
import java.util.ArrayList;

public class Rook extends Chessman{

	public Rook(Table t) {
		super(t);
	}

	@Override
	public List<Field> getValidMoves(int i, int j, boolean blockedOnly) {
		List<Field> retFields = new ArrayList<Field>();
		for (int col = i+1; col < 8; col++) {
			if( (!blockedOnly && t.getField(col,j).isValid())
				||
			    (blockedOnly && t.getField(col,j).isBlocked())){
				retFields.add(t.getField(col, j));
			} else {
				break;
			}
		}
		for (int col = i-1; col >= 0; col--) {
			if( (!blockedOnly && t.getField(col,j).isValid())
			    ||
			    (blockedOnly && t.getField(col,j).isBlocked())){
				retFields.add(t.getField(col, j));
			} else {
				break;
			}
		}
		
		for (int row = j+1; row < 8; row++) {
			if( (!blockedOnly && t.getField(i, row).isValid())
				||
 			    (blockedOnly && t.getField(i, row).isBlocked())){
				retFields.add(t.getField(i, row));
			} else {
				break;
			}
		}
		for (int row = j-1; row >= 0 ; row--) {
			if( (!blockedOnly && t.getField(i, row).isValid())
				||
 			    (blockedOnly && t.getField(i, row).isBlocked())){
				retFields.add(t.getField(i, row));
			} else {
				break;
			}
		}

		System.out.println("GetValidMoves for Rook:"+ t.getField(i,j).toString() + " :" + retFields.toString());
		return retFields;
	}
	
}
