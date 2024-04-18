import java.util.InputMismatchException;
import java.util.Scanner;

public class Gamble extends Player {
	int betmoney;
	int winmoney;

	Scanner scan = new Scanner(System.in);

	public Gamble() {

	}

	//	お金をかける

	public void bet() {
		//いくらかけるか
		//所持金＝所持金-賭け金（もしベットマネーが所持金より少なければ）
		while (true) {

			try {
				System.out.println("いくら賭けますか？(現在の所持金よりも少ない金額を賭けてください)");
				System.out.println("あなたの現在の所持金は" + getHaveMoney() + "です");
				betmoney = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("正しい金額を入力してください\r\n(Enterで進む)");
				scan.next();
				scan.nextLine();
				scan.nextLine();
				System.out.println("いくら賭けますか？(現在の所持金よりも少ない金額を賭けてください)");
				betmoney = 0;
			}
			if ((getHaveMoney() >= betmoney) && (betmoney > 0)) {
				setHaveMoney(getHaveMoney() - betmoney);
				System.out.println("あなたは" + betmoney + "円を賭けました");
				System.out.println("あなたの残りの所持金は" + getHaveMoney() + "です");
				break;
			} else {
				System.out.println("\"正しい金額を入力してください\r\n(Enterで進む)");
				scan.nextLine();
			}

		}

	}
}
