package framework.blackboard;

//消息
public class Notice {
    //信息源的信息
    private String message;
    //通知栏
    Blackboard blackboard;

    public Notice(String message,Blackboard blackboard){
        this.message=message;
        this.blackboard=blackboard;
    }
    public void updateBlackboard(){
        blackboard.update(message);
    }
}
