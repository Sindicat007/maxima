package patterns;

public class NoCommand implements Command{

    @Override
    public void execute() {
        System.out.println("No command");
    }
    public void undo() {
        System.out.println("No command");
    }
//    public void redo(String s) {
//        System.out.println("No command");
//    }
}
