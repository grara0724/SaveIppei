import java.util.Scanner;

public class Text {

	Scanner scan = new Scanner(System.in);

	public void showText1() {

		scan.nextLine();
		System.out.println("\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("\r\n(Enterで進む)");
	}

	public void showText2() {
		System.out.println("あなたは水原一平を知っていますか？\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("彼はビジネスパートナーであり、なおかつ最高の友だった大谷翔平の銀行口座から・・・\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("24.5億円という大金を不正に送金してしまっていたのです\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("あそこを見てください\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("一平がいます\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("富も名声も力も失ってしまい、そのつらさのあまり地面に向かって泣き叫んでいます\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("ここであなたには選択肢があります\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("一つは一平をネットのおもちゃとして味がしなくなるまでネタにすること\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("もう一つはあなたの持っている全所持金の10万円を・・・\r\n(Enterで進む)");
		scan.nextLine();
		System.out.println("ギャンブルで24.5億円まで増やして彼を救うことです\r\n(Enterで進む)");
		scan.nextLine();

		for (int i = 1; i > 0; i++) {
			System.out.println("さあ善良なあなたはどちらを選びますか\r\n①ネットのおもちゃにする  ②ギャンブルで救う\r\n(1か2を入力してください)");
			int choose1 = scan.nextInt();
			if (choose1 == 1) {
				System.out.println("一平はおもちゃじゃないです\r\n(Enterで進む)");
				scan.nextLine();
				scan.nextLine();
			} else if (choose1 == 2) {
				break;
			} else {
				System.out.println("1か2を選んでください\r\n(Enterで進む)");
				scan.nextLine();
			}
		}
		System.out.println("よくぞこの選択肢を選んでくださいました。\r\n(Enterで進む)");
		scan.nextLine();
	}

}
