
public class Player {

	//	String playername;
	private int pocketmoney = 1000000;

	public Player() {

	}

	public int getPocketMoney() {
		return pocketmoney;
	}

	public void setPocketMoney(int pocketMoney) {
		this.pocketmoney = pocketMoney;
	}

	public void showPocketMoney() {
		System.out.println("あなたの所持金は" + pocketmoney + "円です。");
	}

}
