package patternComandFinal;

import java.util.Arrays;

public class Invoker {
    private Command command;
    private final Command[] commands = new Command[5];
    private static int commandPointer = 0;

    public void executeCommand(Command command) {
        command.execute();
        commands[commandPointer] = command;
        commandPointer = commandPointer < commands.length - 1 ? commandPointer + 1 : commandPointer;
    }

    public void undoCommand(Command command) {
        command.undo();
        commands[commandPointer] = command;
        commandPointer = commandPointer < commands.length - 1 ? commandPointer + 1 : commandPointer;
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
        return String.format("Последние %d выполненых команд %n%s%n", commandPointer + 1, sb );
    }
}
