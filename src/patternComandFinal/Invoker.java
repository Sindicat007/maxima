package patternComandFinal;

public class Invoker {
    private Command command;

    public void executeCommand(Command command) {
        command.execute();
    }

    public void undoCommand(Command command) {
        command.undo();
    }
}
