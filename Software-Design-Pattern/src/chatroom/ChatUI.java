package chatroom;

import exceptionhandle.ExceptionHandle;
import framework.simplefactory.Mole;
import singletonlazyinitialization.MoleManor;

import java.util.Scanner;

public class ChatUI {

    //添加角色和聊天室
    private Mole mole = MoleManor.getPlayer();
    private Chatroom chatroom = Chatroom.getInstance();

    public ChatUI(){}

    //发送消息
    private void sendMessage(String message){
        chatroom.addMessage(mole.getMoleName(), message);
    }

    private void showMessage(){
        chatroom.showMessage();
    }


    /**
     * 聊天界面接口
     */
    public void chatting(){

        Scanner scan = new Scanner(System.in);
        ExceptionHandle exceptionHandle = new ExceptionHandle();
        int i = 0;

        MoleManor.printMenu();

        while (true){

            i = exceptionHandle.exception();

            switch (i) {
                case 1:
                    String message = scan.nextLine();

                    try {
                        chatroom.Lock();
                        sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        chatroom.unLock();
                    }

                    break;

                case 2:
                    showMessage();
                    break;
                case 0:
                    System.out.println("已退出聊天室，即将返回摩尔大厅！！！\n\n");
                    return;
                default:
                    break;
            }
        }
    }

}
