package ejnosvn.ChessTravails;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Chessman {

	public Knight(Table t) {
		super(t);
	}

	@Override
	public List<Field> getValidMoves(int i, int j, boolean blockedOnly) {
		List<Field> retFields = new ArrayList<Field>();
		int[][] f_pos = { {i-2,j-1}, {i-1,j-2}, {i+1,j-2}, {i+2,j-1}, {i-2,j+1}, {i-1,j+2}, {i+1,j+2}, {i+2,j+1} };
		
		for (int k = 0; k < f_pos.length; k++) {
			System.out.println("f_pos ?"+ f_pos[k][0] + ":" + f_pos[k][1]);
			if( f_pos[k][0] >= 0 && f_pos[k][0] < 8 &&
				f_pos[k][1] >= 0 && f_pos[k][1] < 8 ){
				System.out.println("f_pos ok:"+ t.getField(f_pos[k][0],f_pos[k][1]).toString());
				if(	(!blockedOnly && t.getField(f_pos[k][0],f_pos[k][1]).isValid())
					||
					(blockedOnly && t.getField(f_pos[k][0],f_pos[k][1]).isBlocked())){
					System.out.println("f_pos added:"+ t.getField(f_pos[k][0],f_pos[k][1]).toString());
					retFields.add(t.getField(f_pos[k][0], f_pos[k][1]));
				} else {
					if(	!blockedOnly && t.getField(f_pos[k][0],f_pos[k][1]).isValid()){
						break;
					}
				}
			}
		}

		System.out.println("GetValidMoves for Knight:"+ t.getField(i,j).toString() + " :" + retFields.toString());
		return retFields;
	}

}
