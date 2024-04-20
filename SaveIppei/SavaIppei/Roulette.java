
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

	//どの賭け方をするかの判定メソッド
	private void chooseBet() {
		while (true) {
			try {
				System.out.println("賭け方を選んでください\r\n(Enterで進む)");
				scan.nextLine();
				System.out.println("1:偶数か奇数かを当てる(当たれば掛け金の2倍)");
				System.out.println("2:1～12,13～24,25～36のどれがくるかを当てる(当たれば掛け金の3倍)");
				System.out.println("3:数字を当てる(当たれば掛け金の36倍)");
				num = scan.nextInt();
				//不正な数字をはじく
				if (num < 1 || num > 3) {
					System.out.println("1から3で選んでください\r\n(Enterで進む)");
					continue;
				}

				//数字以外の入力をはじく
			} catch (InputMismatchException e) {
				System.out.println("1から3で選んでください\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
				continue;
			}
			break;
		}

	}

	//どの数字に賭けるかの判定メソッド
	private void betNumber() {
		while (true) {
			try {
				System.out.println("どの数字にかけますか？");
				num = scan.nextInt();
				//不正な数字をはじく
				if (num < 1 || num > 36) {
					System.out.println("1から36で選んでください\r\n(Enterで進む)");
					scan.nextLine();
					continue;
				}

				//数字以外の入力をはじく
			} catch (InputMismatchException e) {
				System.out.println("1から36で選んでください\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
				continue;
			}
			//賭け金をセット
			bet();
			/*betPositionsマップに賭けた数字とオッズを紐づけてMAPに追加
			後ほど出た数字から（数字,偶数か奇数か,範囲）というString型の文章を作り、
			それと賭けた時に作られるString型の文書を文字列検索で一致するかであたりの判定を行うが、
			数字を文字列にした際に例えば21は1としても識別されてしまうため、数字は$$で囲うことによって対策する*/
			betPositions.put("$" + Integer.toString(num) + "$", 36);
			break;
		}
	}

	//どの範囲に賭けるかの判定メソッド
	private void betField() {
		while (true) {
			try {
				System.out.println("どこに賭けますか？");
				System.out.println("1:1～12  2:13～24  3:25～36");
				num = scan.nextInt();
				//不正な数字をはじく
				if (num < 1 || num > 3) {
					System.out.println("1から3で選んでください\r\n(Enterで進む)");
					scan.nextLine();
					continue;
				}

				//数字以外の入力をはじく
			} catch (InputMismatchException e) {
				System.out.println("1から3で選んでください\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
				continue;
			}
			//betPositionsマップに賭けた範囲とオッズを紐づけてMAPに追加
			bet();
			betPositions.put((num == 1) ? "1～12" : (num == 2) ? "13～24" : "25～36", 3);
			break;
		}
	}

	//偶数か奇数かの判定メソッド
	private void betEorO() {
		while (true) {
			try {
				System.out.println("どちらに賭けますか？");
				System.out.println("1:偶数  2:奇数");
				num = scan.nextInt();
				//不正な数字をはじく
				if (num < 1 || num > 3) {
					System.out.println("1か2で選んでください\r\n(Enterで進む)");
					scan.nextLine();
					continue;
				}

				//数字以外の入力をはじく
			} catch (InputMismatchException e) {
				System.out.println("1か2で選んでください\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
				continue;
			}
			//betPositionsマップに賭けた偶数か奇数かとオッズを紐づけてMAPに追加
			bet();
			betPositions.put((num == 1) ? "偶数" : "奇数", 2);
			break;
		}
	}

	//続けて賭けるかの判定メソッド
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
				}
				//数字以外の入力をはじく
			} catch (InputMismatchException e) {
				System.out.println("1か2で選んでください\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
				continue;
			}
			break;
		}
	}

	//賭けた内容と結果が一致するかの判定とそれに応じて精算するメソッド	
	private void Result() {
		Random rand = new Random();
		hitNumber = rand.nextInt(36) + 1;

		//出た数字から当たりを判定するための文章を生成（当たり判定用の文章とは別に、結果に表示される文章も生成）		
		hitPosition1 = (hitNumber % 2 == 1) ? "奇数" : "偶数";
		hitPosition2 = (hitNumber <= 12) ? "1～12" : (hitNumber <= 24) ? "13～24" : "25～36";
		String hitPosition = ("$" + Integer.toString(hitNumber) + "$" + "," + hitPosition1 + "," + hitPosition2);
		String showHitPosition = ("結果:" + Integer.toString(hitNumber) + "," + hitPosition1 + "," + hitPosition2);
		System.out.println(showHitPosition);

		//betPositionsマップから値（ods）を取り出す
		Set<String> ods = betPositions.keySet();

		//最終的に当たっていた際にcountに1を代入することで、複数賭けしていても一個でも当たれば当たりと表示する
		int count = 0;

		//複数賭けしていた際にトータルで当たった分を計算
		int totalWinMoney = 0;

		for (String str : ods) {
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

		} else {
			System.out.print("はずれ...");
			showPocketMoney();
			System.out.println("\r\n(Enterで進む)");
			scan.nextLine();
			scan.nextLine();
		}
	}
}
