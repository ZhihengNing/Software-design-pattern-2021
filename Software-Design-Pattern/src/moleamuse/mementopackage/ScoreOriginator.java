package moleamuse.mementopackage;

/**
 * @author 罗检
 *
 * 游戏名称与分数信息并存储到mememto中
 */
public class ScoreOriginator {
    private int score;
    private String gameName;
    /**
     * 记录当前游戏名称与分数
     * @param score 得分
     * @param gameName 游戏名称
     */
    public void setRecord(int score, String gameName){
        this.score = score;
        this.gameName = gameName;
    }
    /**
     * 获取分数
     * @return score
     */
    public int getScore(){
        return score;
    }
    /**
     * 获取游戏名称
     * @return gameName
     */
    public String getName(){
        return gameName;
    }
    /**
     * 将当前记录存储到RecordMemento中
     * @return RecordMemento
     */
    public RecordMemento saveRecordToMemento(){
        return new RecordMemento(score, gameName);
    }

}