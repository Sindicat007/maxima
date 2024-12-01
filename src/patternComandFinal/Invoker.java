package patternComandFinal;

public class Invoker {
    private Command command, undoCommand;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        undoCommand = command;
        command.execute();
    }

    public void undoCommand() {
        undoCommand.undo();
    }
}
