import java.util.InputMismatchException;
import java.util.Scanner;

public class Gamble extends Player {
	int betMoney;
	int winMoney;

	public Gamble() {

	}

	//	お金をかける

	public void bet() {
		Scanner scan = new Scanner(System.in);
		int pocketMoney = getPocketMoney(); //毎回getを使うのはあほ

		while (true) {

			try {
				System.out.println("いくら賭けますか？(現在の所持金よりも少ない金額を賭けてください)");
				//				System.out.println("あなたの現在の所持金は" + getPocketMoney() + "です");showPocketMoneyを使う
				showPocketMoney();
				betMoney = scan.nextInt();
				if ((pocketMoney < betMoney) || (betMoney <= 0)) {
					System.out.println("\"正しい金額を入力してください\r\n(Enterで進む)");
					scan.nextLine();
					scan.nextLine();
					continue;
				}

			} catch (InputMismatchException e) {
				System.out.println("正しい金額を入力してください\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
				continue;
			}
			setPocketMoney(pocketMoney - betMoney);
			showPocketMoney();
			System.out.println("(Enterで進む)");
			scan.nextLine();
			scan.nextLine();
			break;
		}

	}

	public void winMoney(int ods) {
		winMoney = betMoney * ods;
		setPocketMoney(getPocketMoney() + winMoney);
		//System.out.println("あたり！あなたは" + winMoney + "獲得しました");
		//showPocketMoney();

	}

	public void showPosition(String position) {
		System.out.println("あなたは" + position + "に" + betMoney + "円賭けました。\r\n残りの所持金は" + getPocketMoney() + "円です");
	}
}
