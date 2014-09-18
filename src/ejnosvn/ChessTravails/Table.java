package ejnosvn.ChessTravails;

public class Table {
	Field[][] table = new Field[8][8];
	Field endField = null;
	
	public final static int START_FIELD = 0;
	public final static int NOTSEENYET_FIELD = -1;
	public final static int BLOCKED_FIELD = 32000;
	
	public Table(){
		for (int i = 0;  i< 8; i++) {
			for (int j = 0;  j< 8; j++) {
				table[i][j] = new Field(i,j, NOTSEENYET_FIELD);
			}
		}
	}
	
	public void storeField(final int i, final String field) {
		switch (i) {
		case 0:
			setValueOfField(Character.getNumericValue(field.charAt(0))-10, Character.getNumericValue(field.charAt(1))-1, Table.START_FIELD);
			break;
		case 1:
			endField = table[Character.getNumericValue(field.charAt(0))-10][Character.getNumericValue(field.charAt(1))-1];
			endField.endField = true;
			break;
		default:
			setValueOfField(Character.getNumericValue(field.charAt(0))-10, Character.getNumericValue(field.charAt(1))-1, Table.BLOCKED_FIELD);
			break;
		}
	}

	public boolean hasTableUnknownField() {
		boolean ret = false;
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++) {
				if(getValueOfField(i,j)  == Table.NOTSEENYET_FIELD){
					ret = true;
					break;
				}
			}
		}
		return ret;
	}

	public boolean setField(Field f, int whichStep) {
		boolean ret = false;
		if(getValueOfField(f.i,f.j) == Table.NOTSEENYET_FIELD){
			setValueOfField(f.i,f.j, whichStep);
		}
		if(getField(f.i,f.j).endField == true){
			ret = true;
		}
		return ret;
	}
	
	public boolean setColumn(int fromX, int fromY, int whichStep) {
		boolean ret = false;
		for (int i = fromY; i < 8; i++) {
			if(getValueOfField(fromX,i) == Table.NOTSEENYET_FIELD){
				setValueOfField(fromX, i, whichStep);
			}
			if(getValueOfField(fromX,i) == Table.BLOCKED_FIELD){
				break;
			}
			if(getField(fromX,i).endField == true){
				ret = true;
				break;
			}
		}
		for (int i = fromY; i >= 0; i--) {
			if(getValueOfField(fromX,i) == Table.NOTSEENYET_FIELD){
				setValueOfField(fromX, i, whichStep);
			}
			if(getValueOfField(fromX,i) == Table.BLOCKED_FIELD){
				break;
			}
			if(getField(fromX,i).endField == true){
				ret = true;
				break;
			}
		}
		return ret;
	}

	public boolean setRow(int fromX, int fromY, int whichStep) {
		boolean ret = false;
		for (int i = fromX; i < 8; i++) {
			if(getValueOfField(i, fromY) == Table.NOTSEENYET_FIELD){
				setValueOfField(i, fromY, whichStep);
			}
			if(getValueOfField(i, fromY) == Table.BLOCKED_FIELD){
				break;
			}
			if(getField(i, fromY).endField == true){
				ret = true;
				break;
			}
		}
		for (int i = fromX; i >= 0; i--) {
			if(getValueOfField(i, fromY) == Table.NOTSEENYET_FIELD){
				setValueOfField(i, fromY, whichStep);
			}
			if(getValueOfField(i, fromY) == Table.BLOCKED_FIELD){
				break;
			}
			if(getField(i, fromY).endField == true){
				ret = true;
				break;
			}
		}
		return ret;
	}
	
	
	public int getValueOfField(int i, int j){
		return table[i][j].value;
	}

	public int getValueOfField(Field f){
		return table[f.i][f.j].value;
	}
	
	public void setValueOfField(int i, int j, int state) {
		table[i][j].value = state;
	}

	public void setValueOfField(Field f, int state) {
		table[f.i][f.j].value = state;
	}

	public Field getField(int i, int j){
		return table[i][j];
	}
	
	public void writeTableToConsole() {
		System.out.println("   A  B  C  D  E  F  G  H");
		for (int j = 0; j < 8; j++) {
			String row = "" + (j+1) + " ";
			for (int i = 0; i < 8; i++) {
				if(getValueOfField(i,j)  > -1){
					if(getField(i,j).isValid() == true){
						row += " " + getValueOfField(i,j)  + " ";
					} else {
						row += " X ";
					}
				} else {
					row += getValueOfField(i,j)  + " ";
				}
			}
			System.out.println(row);
		}
	}

	
}
