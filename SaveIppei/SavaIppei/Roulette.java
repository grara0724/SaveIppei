
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Roulette extends Gamble {

	int hitNumber;
	int num;
	String betPosition;//何に賭けたか
	String hitPosition1;//偶数か奇数か
	String hitPosition2;//範囲はどこか
	Map<String, Integer> betPositions = new HashMap<String, Integer>();//何に賭けたかとその倍率のリスト

	Scanner scan = new Scanner(System.in);

	public Roulette() {
	}

	//	ゲームスタート
	public void playRoulette() {
		System.out.println("ルーレットルームへようこそ\r\n(Enterで進む)");
		scan.nextLine();

		while (true) {
			//どの賭け方をするか
			chooseBet();

			switch (num) {
			//偶数か奇数かを賭けた場合		
			case 1:
				betEorO();
				break;

			//数字の範囲を賭けた場合
			case 2:
				betField();
				break;

			//数字を賭けた場合
			case 3:
				betNumber();
				break;

			}
			//所持金が0になったら強制勝負
			if (getPocketMoney() == 0) {
				break;
			}
			//他にも賭けるか？	
			reBet();
			if (num == 1) {
				continue;
			} else {
				break;

			}

		}

		//結果表示と精算
		Result();

	}

	private void reBet() {
		while (true) {
			try {
				System.out.println("他にも賭けますか？");
				System.out.println("1:他にも賭ける  2:もう賭けない");
				num = scan.nextInt();
				if (num < 1 || num > 2) {
					System.out.println("1か2を選んでください\r\n(Enterで進む)");
					scan.nextLine();
					continue;
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("1か2で選んでください\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
				continue;
			}
		}
	}

	private void betNumber() {
		while (true) {
			try {
				System.out.println("どの数字にかけますか？");
				num = scan.nextInt();
				if (num < 1 && num > 36) {
					System.out.println("1から36で選んでください\r\n(Enterで進む)");
					scan.nextLine();
					continue;
				}
				bet();
				break;
			} catch (InputMismatchException e) {
				System.out.println("1から36で選んでください\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
				continue;
			}
		}
		betPositions.put("$" + Integer.toString(num) + "$", 36);
	}

	private void betField() {
		while (true) {
			try {
				System.out.println("どこに賭けますか？");
				System.out.println("1:1～12  2:13～24  3:25～36");
				num = scan.nextInt();
				if (num < 1 && num > 3) {
					System.out.println("1から3で選んでください\r\n(Enterで進む)");
					scan.nextLine();
					continue;
				}
				bet();
				break;
			} catch (InputMismatchException e) {
				System.out.println("1から3で選んでください\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
				continue;
			}
		}
		betPositions.put((num == 1) ? "1～12" : (num == 2) ? "13～24" : "25～36", 3);
	}

	private void betEorO() {
		while (true) {
			try {
				System.out.println("どちらに賭けますか？");
				System.out.println("1:偶数  2:奇数");
				num = scan.nextInt();
				if (num < 1 && num > 3) {
					System.out.println("1か2で選んでください\r\n(Enterで進む)");
					scan.nextLine();
					continue;
				}
				bet();
				break;
			} catch (InputMismatchException e) {
				System.out.println("1か2で選んでください\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
				continue;
			}
		}
		betPositions.put((num == 1) ? "偶数" : "奇数", 2);
	}

	private void chooseBet() {
		while (true) {
			try {
				System.out.println("賭け方を選んでください\r\n(Enterで進む)");
				scan.nextLine();
				System.out.println("1:偶数か奇数かを当てる(当たれば掛け金の2倍)");
				System.out.println("2:1～12,13～24,25～36のどれがくるかを当てる(当たれば掛け金の3倍)");
				System.out.println("3:数字を当てる(当たれば掛け金の36倍)");
				num = scan.nextInt();
				if (num < 1 && num > 3) {
					System.out.println("1から3で選んでください\r\n(Enterで進む)");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("1から3で選んでください\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
				continue;
			}
		}

	}

	private void Result() {
		Random rand = new Random();
		hitNumber = rand.nextInt(36) + 1;
		hitPosition1 = (hitNumber % 2 == 1) ? "奇数" : "偶数";
		hitPosition2 = (hitNumber <= 12) ? "1～12" : (hitNumber <= 24) ? "13～24" : "25～36";
		String hitPosition = ("$" + Integer.toString(hitNumber) + "$" + "," + hitPosition1 + "," + hitPosition2);
		String showHitPosition = (Integer.toString(hitNumber) + "," + hitPosition1 + "," + hitPosition2);
		System.out.println("結果:" + showHitPosition);

		Set<String> keys = betPositions.keySet();
		int count = 0;
		int totalWinMoney = 0;
		for (String str : keys) {
			if (hitPosition.indexOf(str) != -1) {
				count = 1;
				winMoney(betPositions.get(str));
				totalWinMoney += winMoney;
			} else {
			}
		}
		if (count == 1) {
			System.out.println("あたり！あなたは" + totalWinMoney + "円獲得しました");
			showPocketMoney();
			System.out.println("\r\n(Enterで進む)");
			scan.nextLine();
			scan.nextLine();

		}
		if (count == 0) {
			System.out.print("はずれ...");
			showPocketMoney();
			System.out.println("\r\n(Enterで進む)");
			scan.nextLine();
			scan.nextLine();
		}
	}
}
