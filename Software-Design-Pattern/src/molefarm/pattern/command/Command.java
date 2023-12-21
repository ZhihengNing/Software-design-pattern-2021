package molefarm.pattern.command;

/**
 * 抽象命令
 */
public interface Command {
    public boolean execute(String name, int num);
}
