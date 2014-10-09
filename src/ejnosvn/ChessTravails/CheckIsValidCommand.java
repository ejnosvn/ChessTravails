package ejnosvn.ChessTravails;

import ejnosvn.ChessTravails.Field.FieldCommand;

public class CheckIsValidCommand implements FieldCommand {

    @Override
    public boolean execute(Field field) {
        return field.isValid();
    }

}
