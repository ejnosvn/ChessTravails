package ejnosvn.ChessTravails;

import ejnosvn.ChessTravails.Field.FieldCommand;

public class CheckIsNotBlockedCommand implements FieldCommand {

    @Override
    public boolean execute(Field field) {
        return field.isNotBlocked();
    }

}
