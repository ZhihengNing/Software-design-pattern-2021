package framework.blackboard;

import java.util.ArrayList;

public class Blackboard {
    ArrayList<String> noticeList;
    public Blackboard(){
        this.noticeList=new ArrayList<>();
    }
    public void show(){
        int number=1;
        System.out.println("----- 公告 -----");
        for(String s:noticeList){
            String mes=number+"."+s;
            System.out.println(mes);
            number++;
        }
    }
    public void update(String s){
        noticeList.add(s);
    }
}
