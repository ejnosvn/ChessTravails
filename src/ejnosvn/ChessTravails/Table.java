package ejnosvn.ChessTravails;

public class Table {
	private Field[][] table = new Field[8][8];
	private Field endField = null;
	
	public Table(){
		for (int i = 0;  i< 8; i++) {
			for (int j = 0;  j< 8; j++) {
				table[i][j] = new Field(i,j, Field.NOT_VISITED);
			}
		}
	}
	
	public void storeField(final int i, final String field) {
		switch (i) {
		case 0:
			setValueOfField(Character.getNumericValue(field.charAt(0))-10, Character.getNumericValue(field.charAt(1))-1, Field.START);
			break;
		case 1:
			endField = table[Character.getNumericValue(field.charAt(0))-10][Character.getNumericValue(field.charAt(1))-1];
			endField.setEndField(true);
			break;
		default:
			setValueOfField(Character.getNumericValue(field.charAt(0))-10, Character.getNumericValue(field.charAt(1))-1, Field.BLOCKED);
			break;
		}
	}

	public boolean hasTableUnknownField() {
		boolean ret = false;
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++) {
				if(getField(i,j).isNotVisited()){
					ret = true;
					break;
				}
			}
		}
		return ret;
	}

	public boolean setField(Field f, int whichStep) {
		boolean ret = false;
		if(getField(f.column,f.row).isNotVisited()){
			setValueOfField(f.column,f.row, whichStep);
		}
		if(getField(f.column,f.row).isEndField() == true){
			ret = true;
		}
		return ret;
	}
	
	public boolean setColumn(int fromX, int fromY, int whichStep) {
		boolean ret = false;
		for (int i = fromY; i < 8; i++) {
			if(getField(fromX,i).isNotVisited()){
				setValueOfField(fromX, i, whichStep);
			}
			if(!getField(fromX,i).isNotBlocked()){
				break;
			}
			if(getField(fromX,i).isEndField() == true){
				ret = true;
				break;
			}
		}
		for (int i = fromY; i >= 0; i--) {
			if(getField(fromX,i).isNotVisited()){
				setValueOfField(fromX, i, whichStep);
			}
			if(!getField(fromX,i).isNotBlocked()){
				break;
			}
			if(getField(fromX,i).isEndField() == true){
				ret = true;
				break;
			}
		}
		return ret;
	}

	public boolean setRow(int fromX, int fromY, int whichStep) {
		boolean ret = false;
		for (int i = fromX; i < 8; i++) {
			if(getField(i, fromY).isNotVisited()){
				setValueOfField(i, fromY, whichStep);
			}
			if(!getField(i,fromY).isNotBlocked()){
				break;
			}
			if(getField(i, fromY).isEndField() == true){
				ret = true;
				break;
			}
		}
		for (int i = fromX; i >= 0; i--) {
			if(getField(i, fromY).isNotVisited()){
				setValueOfField(i, fromY, whichStep);
			}
			if(!getField(i,fromY).isNotBlocked()){
				break;
			}
			if(getField(i, fromY).isEndField() == true){
				ret = true;
				break;
			}
		}
		return ret;
	}
	
	public void setValueOfField(int i, int j, int state) {
		table[i][j].reachedInStepNumber = state;
	}

	public void setValueOfField(Field f, int state) {
		table[f.column][f.row].reachedInStepNumber = state;
	}

	public Field getField(int i, int j){
		return table[i][j];
	}
	
	public void writeTableToConsole() {
		System.out.println("   A  B  C  D  E  F  G  H");
		for (int j = 0; j < 8; j++) {
			String row = "" + (j+1) + " ";
			for (int i = 0; i < 8; i++) {
				if(getField(i,j).getValue()  > -1){
					if(getField(i,j).isValid() == true){
						row += " " + getField(i,j).getValue()  + " ";
					} else {
						row += " X ";
					}
				} else {
					row += getField(i,j).getValue()  + " ";
				}
			}
			System.out.println(row);
		}
	}

	
}
