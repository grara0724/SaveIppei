import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayCasino {

	public static void main(String[] args) {

		//インスタンス化			
		Roulette roulette = new Roulette();
		Scanner scan = new Scanner(System.in);
		Player player = new Player();
		Text text = new Text();

		//		フィールド
		//        int gamestart;  yesかnoかはbooleanを使うことでif文を使ってきれいに分岐できる。変数名としてgameStartは変
		boolean isStart;

		//初期の所持金10万円をセット		
		player.setPocketMoney(100000);

		//ゲームを始める
		System.out.println("一平を救え！～目指せギャンブル王～\r\n(Enterで進む)");
		scan.nextLine();

		//例外処理
		while (true) { //無限ループ
			try {

				System.out.println("ゲームを始めますか？\r\n1:始める  2:始めない");
				int tmp; //scanの入れ箱　ここでの判定しか使わないのでスコープ範囲は狭く
				tmp = scan.nextInt();
				if (tmp > 2 || tmp < 1)
					continue;

				isStart = (tmp == 1) ? true : false; //三項演算子 (条件式)? 式1 : 式2 条件式がtrueならば式1をfalseなら2を返す

				break;
			} catch (InputMismatchException e) {

				System.out.println("1か2を選んでください\r\n(Enterで進む)");
				scan.nextLine(); //一個目でまだ判定が残っているnextIntキャンセル  nextだけやとenterが改行判定にならないのでnextLiine
				scan.nextLine();

				continue;

				//				scan.nextLine();
				//				System.out.println("ゲームを始めますか？\r\n1:始める  2:始めない"); ループで使いまわす方が無駄な記述が少なくて済む
			}
		}

		if (isStart) {

			//ゲームのストーリー説明
			text.showText2();

			int gameNumber;
			while (true) {
				try {

					System.out.println("どのゲームを選びますか？");
					System.out.println("1:ルーレット");
					gameNumber = scan.nextInt();
					if (gameNumber > 3 || gameNumber < 1) {
						System.out.println("正しい数字を入力してください/r/n(Enterで進む)");
						scan.nextLine();
						continue;
					}

				} catch (InputMismatchException e) {
					System.out.println("正しい数字を入力してください\r\n(Enterで進む)");
					scan.nextLine();
					scan.nextLine();
					continue;
				}
				switch (gameNumber) {
				case 1:
					roulette.playRoulette();

				}
				//名前の登録+playernameに入力された名前をセット
				//			
				//				player.playername = scan.nextLine();

				//10万円もっていることを説明

				//選べるギャンブルの説明

				//ここからfor文とif文を組み合わせてお金があればゲームを続けるかやめるかを選べる
				//お金がなくてもお金を借りれば続行		

				//遊ぶギャンブルを選ぶ(havemoneyが1以上なら)

				//ゲームオーバーもしくは大谷翔平からお金を借りる(havemoneyが0なら)

			}

		}

	}
}
