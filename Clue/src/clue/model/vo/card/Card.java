package clue.model.vo.card;

public class Card {
	private int cardKinds;// 분류 1.인물 2.도구 3.장소 4.보너스
	private int cardNum;// 카드 번호
	private String name;// 카드이름

	public Card() {
	}

	public Card(int cardKinds, int cardNum, String name) {
		this.cardKinds = cardKinds;
		this.cardNum = cardNum;
		this.name = name;
	}

	public int getCardKinds() {
		return cardKinds;
	}

	public void setCardKinds(int cardKinds) {
		this.cardKinds = cardKinds;
	}

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return cardKinds + " " + cardNum + " " + name;
	}
}