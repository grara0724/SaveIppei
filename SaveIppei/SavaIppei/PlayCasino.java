import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayCasino {

	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);			
		Player player = new Player();
		Text text = new Text();
		
		boolean isStart;
		
		player.setHaveMoney(100000);
		
		System.out.println("一平を救え！～目指せギャンブル王～\r\n(Enterで進む)");
		scan.nextLine();
		
		//ゲームのスタート有無を選択
		while (true) {
			try {
				System.out.println("ゲームを始めますか？\r\n1:始める  2:始めない");
				int tmp;
				tmp = scan.nextInt();
				if( tmp > 2 && tmp < 1 ) continue;
				
				isStart = (tmp == 1) ? true : false;

				break;
			} catch (InputMismatchException e) {
				System.out.println("[Error]:1か2を選んでください");
				scan.nextLine();
				continue;
			}
		}
		
		//ゲームの処理
		if (isStart) {

			//ゲームのストーリー説明
			text.showText2();

			//名前の登録+playernameに入力された名前をセット
			player.playername = scan.nextLine();

			//10万円もっていることを説明

			//選べるギャンブルの説明

			//ここからfor文とif文を組み合わせてお金があればゲームを続けるかやめるかを選べる
			//お金がなくてもお金を借りれば続行		

			//遊ぶギャンブルを選ぶ(havemoneyが1以上なら)


		}

		System.out.println("ゲームを終了します");
	}
}
