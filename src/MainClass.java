import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        int userGu = 10; // 초기값은 10개
        int computerGu = 10;
        int bet = 0;
        String holjak;
        String dab;

        System.out.println("오징어 게임에 오신것을 환영합니다");
        System.out.println("이번 게임은 구슬 게임입니다.");
        System.out.println("당신과 나는 각각 10개의 구슬을 가지고 있습니다");
        System.out.println("10개의 구슬을 다 잃으면 죽습니다.");
        System.out.println("시작합니다.");
        System.out.println("배팅 하세요.");
        String name = "이름";

        Scanner sc = new Scanner(System.in); // 입력 받기 위한 준비
        // 배팅 숫자를 입력 받기
        while (true) {

            System.out.print("입력 : ");
            bet = sc.nextInt();  // 숫자를 입력 받아서 bet 변수에 저장
            while(true){
                if (bet > userGu) {
                    System.out.println("배팅 할 수 있는 구슬의 갯수를 초과하였습니다. 다시 입력하세요.");
                }
                else {
                    System.out.println("당신은 " + bet + "개의 구슬을 배팅했습니다.");
                    System.out.println("게임 시작.");
                    break;
                }
            }
            System.out.print("홀(1) 짝(2) 둘중에 하나를 고르세요 :");
            holjak = sc.next();


            // 컴퓨터가 구슬 10개 중에 랜덤으로 문제를 냄
            Random random = new Random();
            int rNum = random.nextInt(computerGu) + 1;
            System.out.println("컴퓨터가 낸 구슬 : " + rNum);

            if (rNum % 2 == 1) {
                System.out.println("정답 : 홀");
                dab = "홀";
            } else {
                System.out.println("정답 : 짝");
                dab = "짝";
            }

            if (Objects.equals(holjak, dab)) {
                System.out.println("맞추셨습니다 !");
                userGu += rNum;
                computerGu -= rNum;
            } else {
                System.out.println("틀렸습니다.");
                userGu -= bet;
                computerGu += bet;
            }
            System.out.println("당신이 가진 구슬 개수는 : " + userGu + " 컴퓨터가 가진 구슬 개수는 : " + computerGu);
            if ( userGu >= 20){
                System.out.println("구슬 20개를 획득하여 승리하였습니다 !");
                break;
            }
            else if (userGu <= 0){
                System.out.println("구슬을 모두 잃어 사망하였습니다.");
                break;
            }
        }
    }
}
