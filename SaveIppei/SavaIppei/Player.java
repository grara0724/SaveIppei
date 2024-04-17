
public class Player {

	String playername;
	private int havemoney;

	public Player() {

	}

	public int getHaveMoney() {
		return havemoney;
	}

	public void setHaveMoney(int havemoney) {
		this.havemoney = havemoney;
	}

	public void showMoney() {
		System.out.println("あなたの所持金は" + havemoney + "円です。");
	}

}
