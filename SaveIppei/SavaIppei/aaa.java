import java.util.Scanner;

public class aaa {

	public static void main(String[] args) {
		int gamemoney;
		int betmoney;

		Scanner scan = new Scanner(System.in);
		Gamble gamble = new Gamble();
		gamble.setHaveMoney(100000);
		gamemoney = gamble.getHaveMoney();

		gamble.bet();
	}
}
