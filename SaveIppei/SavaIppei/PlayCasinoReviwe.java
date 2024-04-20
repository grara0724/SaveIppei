import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayCasinoReviwe {

	public static void main(String[] args) {

		//スキャナーの呼び出し		
		Scanner scan = new Scanner(System.in);

		//インスタンス化			
		Player player = new Player();
		Text text = new Text();

		boolean isStart;

		//初期の所持金10万円をセット		
		player.setHaveMoney(100000);

		//ゲームを始める
		System.out.println("一平を救え！～目指せギャンブル王～\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("ゲームを始めますか？\r\n1:始める  2:始めない");

		//例外処理
		while (true) { //無限ループ
			try {
				int tmp;
				tmp = scan.nextInt();
				if()
				break; //数字が入力されるとループから抜け出す
			} catch (InputMismatchException e) {
				System.out.println("1か2を選んでください\r\n(Enterで進む)");
				scan.next();
				scan.nextLine();
				scan.nextLine();
				System.out.println("ゲームを始めますか？\r\n1:始める  2:始めない");
				isStart = 0;
			}
		}
		while (true) {

			if (isStart == 1) {

				//ゲームのストーリー説明
				text.showText2();

				//名前の登録+playernameに入力された名前をセット
				player.playername = scan.nextLine();

				//10万円もっていることを説明

				//選べるギャンブルの説明

				//ここからfor文とif文を組み合わせてお金があればゲームを続けるかやめるかを選べる
				//お金がなくてもお金を借りれば続行		

				//遊ぶギャンブルを選ぶ(havemoneyが1以上なら)

				//ゲームオーバーもしくは大谷翔平からお金を借りる(havemoneyが0なら)

			} else if (isStart == 2) {
				break;
			} else {
				System.out.println("1か2を選んでください\r\nゲームを始めますか？\\r\\n1:始める  2:始めない");
			}

		}

		System.out.println("ゲームを終了します");
	}
}
