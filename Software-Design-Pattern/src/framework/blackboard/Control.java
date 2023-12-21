package framework.blackboard;

import java.util.ArrayList;

public class Control {
    /**
     * 消息
     */
    ArrayList<Notice>notices;

    Blackboard blackboard;
    public Control(Blackboard blackboard){
        this.notices=new ArrayList<>();
        this.blackboard=blackboard;
    }
    /**
     * 向公告栏中添加公告
     * 添加完毕后清空公告
     */
    public void addAllNotice(){
        for(Notice notice:notices){
            notice.updateBlackboard();
        }
        this.notices=new ArrayList<>();
    }

    public void addNotice(String message){
        this.notices.add(new Notice(message,blackboard));
    }

}
