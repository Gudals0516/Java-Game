import java.util.Scanner;
public class Game{
    boolean start = true;
    static int score = 0;
    int ran = 0;
    String computer;
    String input;
    String win = "이겼습니다";
    String lose = "졌습니다";
    String deuce = "비겼습니다";

    public void run(){
        ran = (int) (Math.random() * 3 + 1);
        // 가위 = 1 바위 =2 보 =3
        if(ran==1){computer="가위";} else if(ran==2){computer="바위";} else if(ran==3){computer="보";}
        if(input.equals("가위")){
            if(ran==1){
                System.out.println("비겼습니다");
                GameFrame.msg = deuce;
            }else if(ran==2){
                System.out.println("졌습니다");
                GameFrame.msg = lose;
            }else if(ran==3){
                System.out.println("이겼습니다");
                GameFrame.msg = win;
                score++;
            }
        }
        if(input.equals("바위")){
            if(ran==2){
                System.out.println("비겼습니다");
                GameFrame.msg = deuce;
            }else if(ran==3){
                System.out.println("졌습니다");
                GameFrame.msg = lose;
            }else if(ran==1){
                System.out.println("이겼습니다");
                GameFrame.msg = win;
                score++;
            }
        }
        if(input.equals("보")){
            if(ran==3){
                System.out.println("비겼습니다");
                GameFrame.msg = deuce;
            }else if(ran==1){
                System.out.println("졌습니다");
                GameFrame.msg = lose;
            }else if(ran==2){
                System.out.println("이겼습니다");
                GameFrame.msg = win;
                score++;
            }
        }
        if(input.equals("종료")){
            System.out.println("종료합니다");
            start = false;
        }
        if(input.equals("가위")==false && input.equals("바위")==false && input.equals("보")==false
                && input.equals("종료")==false && input.equals("user")==false){
            GameFrame.msg = "다시 입력해주세요";
        }
    }//run
}//class
