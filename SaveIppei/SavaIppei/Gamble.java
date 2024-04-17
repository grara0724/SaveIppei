import java.util.InputMismatchException;
import java.util.Scanner;

public class Gamble extends Player {
	int betmoney;
	int winmoney;
	int gamemoney;

	Scanner scan = new Scanner(System.in);

	public Gamble() {

	}

	//	お金をかける

	public void Bet() {
		//いくらかけるか
		System.out.println();

		super.showMoney();
		//所持金＝所持金-賭け金（もしベットマネーが所持金より少なければ）
		while (true) {

			try {
				betmoney = scan.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("正しい金額を入力してください\r\n(Enterで進む)");
				scan.next();
				scan.nextLine();
				scan.nextLine();
				System.out.println("いくら賭けますか？(現在の所持金よりも少ない金額を賭けてください)");
				betmoney = 0;
			}
			if (gamemoney >= betmoney && betmoney > 0) {
				gamemoney -= betmoney;
				System.out.println("あなたの現在の所持金は" + gamemoney + "です");
				break;
			} else {
				System.out.println("\"正しい金額を入力してください\r\n(Enterで進む)");
				scan.nextLine();
				System.out.println("いくら賭けますか？(現在の所持金よりも少ない金額を賭けてください)");
			}

		}

	}
}
