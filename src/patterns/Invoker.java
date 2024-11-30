package patterns;

import java.util.Arrays;

public class Invoker {
    private Command[] commands;
    private Command createTask;
    private Command deleteTask;
    private Command updateTask;
    private Command undoCommand;
    private static int count = 0;

    public Invoker() {
        commands = new Command[10];
        Command noCommand = new NoCommand();
        Arrays.fill(commands, noCommand);
        undoCommand = noCommand;
    }

    public void setCommand(Command createTask, Command deleteTask, Command updateTask) {
        this.createTask = createTask;
        this.deleteTask = deleteTask;
        this.updateTask = updateTask;
    }

    public void createTask() {
        createTask.execute();
        commands[count] = createTask;
        undoCommand = createTask;
        count = count < commands.length - 1 ? count + 1 : count;
    }

    public void deleteTask() {
        deleteTask.execute();
        commands[count] = deleteTask;
        undoCommand = deleteTask;
        count = count < commands.length - 1 ? count + 1 : count;
    }

    public void updateTask(String text) {
        updateTask.execute();
        commands[count] = updateTask;
        undoCommand = updateTask;
        count = count < commands.length - 1 ? count + 1 : count;
    }

    public void undoLastAction() {
        undoCommand.undo();
        commands[count] = undoCommand;
        count = count < commands.length - 1 ? count + 1 : count;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        StringBuilder resUndo = new StringBuilder();

        resUndo.append("Последняя команда: ")
                .append(undoCommand.getClass().getName());


        for (int i = 0; i < commands.length; i++) {
            result.append("Команда № ")
                    .append(i + 1)
                    .append(" ")
                    .append(commands[i].getClass().getName())
                    .append("\n");
        }
        return "Последние " + count + " выполненых команд \n" + result + "\n" + resUndo;


    }
}
