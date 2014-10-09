package ejnosvn.ChessTravails;

public class Field {
	int column = -1;
	int row = -1;
	int reachedInStepNumber = -1;
	private boolean isEndField = false;
	public final static int BLOCKED = 32000;
	public final static int NOT_VISITED = -1;
	public final static int START = 0;
	
	public Field(int column, int row, int reachedInStepNumber) {
		this.column = column;
		this.row = row;
		this.reachedInStepNumber = reachedInStepNumber;
	}
	
	public String toString(){
		return "" + Character.toString(Character.toChars(column+65)[0]) + "" + (row+1);
	}
	
	public boolean isValid() {
		return reachedInStepNumber != NOT_VISITED && reachedInStepNumber != BLOCKED;
	}

	public boolean isNotBlocked() {
		return reachedInStepNumber != BLOCKED;
	}

	public boolean isNotVisited() {
        return reachedInStepNumber == NOT_VISITED;
    }
	
	public boolean isEndField() {
		return isEndField;
	}

	public void setEndField(boolean isEndField) {
		this.isEndField = isEndField;
	}

    public interface FieldCommand {
        public boolean execute(Field field);
    }
}
