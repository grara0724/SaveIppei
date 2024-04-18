import java.util.InputMismatchException;
import java.util.Scanner;

public class Gamble extends Player {
	int betmoney;
	int winmoney;
	
	
	public Gamble() {
	}
	
	//	お金をかける
	public void bet() {
		Scanner scan = new Scanner(System.in);
		int myMoney = getHaveMoney();

		//いくらかけるか
		//所持金＝所持金-賭け金（もしベットマネーが所持金より少なければ）
		while (true) {
			try {
				System.out.println("いくら賭けますか？(現在の所持金よりも少ない金額を賭けてください)");
				showMoney();
				betmoney = scan.nextInt();

				if((myMoney < betmoney) || betmoney == 0) {
					System.out.println("\"正しい金額を入力してください\r\n(Enterで進む)");
					scan.nextLine();
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("正しい金額を入力してください\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
			}

			setHaveMoney(myMoney - betmoney);
			System.out.println("あなたは" + betmoney + "円を賭けました");
			showMoney();

			break;
		}

	}
}
