package ejnosvn.ChessTravails;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Chessman {

	public Knight(Table t) {
		super(t);
	}

	@Override
	public List<Field> getValidMoves(int startCol, int startRow) {
		List<Field> retFields = new ArrayList<Field>();
		int[][] f_pos = { { startCol - 2, startRow - 1 }, { startCol - 1, startRow - 2 },
				{ startCol + 1, startRow - 2 }, { startCol + 2, startRow - 1 }, { startCol - 2, startRow + 1 },
				{ startCol - 1, startRow + 2 }, { startCol + 1, startRow + 2 }, { startCol + 2, startRow + 1 } };

		for (int k = 0; k < f_pos.length; k++) {
			//			System.out.println("f_pos ?"+ f_pos[k][0] + ":" + f_pos[k][1]);
			if (f_pos[k][0] >= 0 && f_pos[k][0] < 8 && f_pos[k][1] >= 0 && f_pos[k][1] < 8) {
				//				System.out.println("f_pos ok:"+ t.getField(f_pos[k][0],f_pos[k][1]).toString());
				if (t.getField(f_pos[k][0], f_pos[k][1]).isValid()) {
					//					System.out.println("f_pos added:"+ t.getField(f_pos[k][0],f_pos[k][1]).toString());
					retFields.add(t.getField(f_pos[k][0], f_pos[k][1]));
				} else {
					if (t.getField(f_pos[k][0], f_pos[k][1]).isValid()) {
						break;
					}
				}
			}
		}

		//		System.out.println("GetValidMoves for Knight:"+ t.getField(startCol,startRow).toString() + " :" + retFields.toString());
		return retFields;
	}

	@Override
	public List<Field> getNotBlockedMoves(int startCol, int startRow) {
		List<Field> retFields = new ArrayList<Field>();
		int[][] f_pos = { { startCol - 2, startRow - 1 }, { startCol - 1, startRow - 2 },
				{ startCol + 1, startRow - 2 }, { startCol + 2, startRow - 1 }, { startCol - 2, startRow + 1 },
				{ startCol - 1, startRow + 2 }, { startCol + 1, startRow + 2 }, { startCol + 2, startRow + 1 } };

		for (int k = 0; k < f_pos.length; k++) {
			//			System.out.println("f_pos ?"+ f_pos[k][0] + ":" + f_pos[k][1]);
			if (f_pos[k][0] >= 0 && f_pos[k][0] < 8 && f_pos[k][1] >= 0 && f_pos[k][1] < 8) {
				//				System.out.println("f_pos ok:"+ t.getField(f_pos[k][0],f_pos[k][1]).toString());
				if (t.getField(f_pos[k][0], f_pos[k][1]).isNotBlocked()) {
					//					System.out.println("f_pos added:"+ t.getField(f_pos[k][0],f_pos[k][1]).toString());
					retFields.add(t.getField(f_pos[k][0], f_pos[k][1]));
				}
			}
		}

		//		System.out.println("GetValidMoves for Knight:"+ t.getField(startCol,startRow).toString() + " :" + retFields.toString());
		return retFields;
	}

}
