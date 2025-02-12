package patternComandFinal;

public interface Command {
    void execute();

    void undo();

    void redo();

    String getDescription();
}
