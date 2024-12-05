package patternComandFinal;

public class Invoker {
    private Command[] commands = new Command[5];
    private static int commandPointer = 0;

    public void executeCommand(Command command) {
        command.execute();
        commands[commandPointer] = command;
        increaseCommandsArrayAndPointer(commands);
    }

    public void undoCommand(Command command) {
        command.undo();
        commands[commandPointer] = command;
        increaseCommandsArrayAndPointer(commands);
    }

    public void increaseCommandsArrayAndPointer(Command[] commands) {
        if (commandPointer < commands.length - 1) {
            commandPointer++;
        } else if (commandPointer >= commands.length - 1) {
            Command[] newCommands = new Command[commands.length * 2];
            System.arraycopy(commands, 0, newCommands, 0, commands.length);
            this.commands = newCommands;
            commandPointer++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] != null) {
                sb.append("Команда № ")
                        .append(i + 1)
                        .append(" ")
                        .append(commands[i].getClass().getName())
                        .append("\n");
            }
        }
        return String.format("Последние %d выполненых команд %n%s%n", commandPointer, sb);
    }
}
