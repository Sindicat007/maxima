package patternComandFinal;

public class Invoker {
    private Command[] history = new Command[5];
    private static int commandPointer = 0;

    public void executeCommand(Command command) {
        command.execute();
        history[commandPointer] = command;
        increaseCommandsArrayAndPointer(history);
    }

    public void undoCommand(Command command) {
        command.undo();
        history[commandPointer] = command;
        increaseCommandsArrayAndPointer(history);
    }

    public void redo(CreateTaskCommand flowerCommand) {
        flowerCommand.redo();
        history[commandPointer] = flowerCommand;
        increaseCommandsArrayAndPointer(history);
    }

    public void increaseCommandsArrayAndPointer(Command[] commands) {
        if (commandPointer < commands.length - 1) {
            commandPointer++;
        } else if (commandPointer >= commands.length - 1) {
            Command[] newCommands = new Command[commands.length * 2];
            System.arraycopy(commands, 0, newCommands, 0, commands.length);
            this.history = newCommands;
            commandPointer++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < history.length; i++) {
            if (history[i] != null) {
                sb.append("Команда № ")
                        .append(i + 1)
                        .append(" ")
                        .append(history[i].getDescription())
                        .append("\n");
            }
        }
        return String.format("Последние %d выполненых команд %n%s%n", commandPointer, sb);
    }
}
