package ejnosvn.ChessTravails;

public class Field {
	int i = -1;
	int j = -1;
	int value;   //1.. hanyadik lepesben elerheto
	boolean endField = false;
	
	public Field(int i, int j, int value) {
		this.i = i;
		this.j = j;
		this.value = value;
	}
	
	public String toString(){
		return "" + Character.toString(Character.toChars(i+65)[0]) + "" + (j+1);
		
	}
	
	public boolean isValid() {
		//System.out.println("SJZ isValid " + toString() + " :::: " + (value != Table.NOTSEENYET_FIELD && value != Table.BLOCKED_FIELD));
		return value != Table.NOTSEENYET_FIELD && value != Table.BLOCKED_FIELD;
	}

	public boolean isBlocked() {
		return value != Table.BLOCKED_FIELD;
	}

}
