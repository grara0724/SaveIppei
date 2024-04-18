
public class Player {

	//	String playername;
	private int pocketMoney;

	public Player() {

	}

	public int getpocketMoney() {
		return pocketMoney;
	}

	public void setpocketMoney(int pocketMoney) {
		this.pocketMoney = pocketMoney;
	}

	public void showMoney() {
		System.out.println("あなたの所持金は" + pocketMoney + "円です。");
	}

}
