package molefarm.pattern.proxy;

import molefarm.pattern.command.conc.FertilizerCommand;
import molefarm.pattern.command.conc.SeedCommand;

/**
 * 代理模式
 * 仓库向商店进货
 */
public class Proxy {
    private FertilizerCommand fertilizerCommand = new FertilizerCommand();;
    private SeedCommand seedCommand = new SeedCommand();;

    public void setFertilizerCommand(FertilizerCommand fertilizerCommand) {
        this.fertilizerCommand = fertilizerCommand;
    }

    public void setSeedCommand(SeedCommand seedCommand) {
        this.seedCommand = seedCommand;
    }

    public boolean seedPurchase(String name, int num){
        return seedCommand.execute(name,num);
    }
    public boolean fertilizerPurchase(String name, int num){
        return fertilizerCommand.execute(name,num);
    }
}
