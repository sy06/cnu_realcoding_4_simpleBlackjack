package com.cnu.blackjack;

import java.util.Scanner;

public class AppIO {

    public void AppIO_msg_Welcome(){
        System.out.println();
        System.out.println("Blackjack 게임을 시작합니다.");
    }

    public void AppIO_CurrentAsset(int money){
        System.out.println("현재 당신은 $"+money+"를 가지고 있습니다.");
    }

    public void AppIO_RangeOfMoney(int money){
        System.out.println("가지고 있는 금액의 범위를 초과하셨습니다. 배팅 금액의 범위는 ( 0부터 " + money + " )");
        System.out.println();
    }

    public void AppIO_msg_Bet(String name){
        System.out.println(name+": 배팅할 금액을 입력하세요");
    }

    public int AppIO_EnterBet(){
        Scanner sc = new Scanner(System.in);
        int bet = sc.nextInt();
        return bet;
    }

    public void AppIO_msg_WasteMoney(){
        System.out.println();
        System.out.println("당신은 현재 돈이 없는 것 같군요!");
        System.out.println("게임이 자동 종료됩니다! 수고하셨습니다!");
        System.out.println();
    }

    public void AppIO_msg_SameBurst(){
        System.out.println("***딜러와 당신 모두 21점을 넘겼으므로 동점입니다. 무승부입니다!***");
    }

    public void AppIO_msg_UserHit(String name){
        System.out.println("플레이어 "+name+"은 Hit을 선택했습니다.");
    }

    public void AppIO_msg_UserStand(String name){
        System.out.println("플레이어 "+name+"은 Stand을 선택했습니다.");
    }

    public void AppIO_msg_Over21byDealer(){
        System.out.println("딜러는 21점을 초과했습니다.");
    }

    public void AppIO_msg_Over21byPlayer(String name){
        System.out.println("플레이어 "+name+"은 21점을 초과했습니다.");
    }

    public void AppIO_PlayWinandPoint(int ph, int dh,String name){
        System.out.println("***"+name+"의 승리입니다! ( 최종 플레이어의 총점 : " + ph + " , 최종 딜러의 총점 : " + dh + " )***");
    }

    public void AppIO_DealerWinandPoint(int dh,int ph){
        System.out.println("***딜러의 승리입니다! ( 최종 딜러의 총점 : " + dh + " , 최종 플레이어의 총점 : " + ph + " )***");
    }

    public void AppIO_msg_DealerWinWhenSameScore(String name) {
        System.out.println("***딜러와 동점입니다. 플레이어 "+name+"의 패배입니다!***");
    }

    public void AppIO_msg_WinBlackjack_Dealer(){
        System.out.println("딜러의 블랙잭! 딜러의 승리입니다!");
    }

    public void AppIO_msg_WinBlackjack_Player(String name){
        System.out.println(name+"의 블랙잭! " + name + "의 승리입니다!");
    }
}
