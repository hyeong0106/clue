package clue.model.vo.card;

public class ThingsCards extends Card {
	// 도구카드
	private Card[] thingsCard = new Card[6];
	{
		thingsCard[0] = new Card(2, 7, "밧줄");
		thingsCard[1] = new Card(2, 8, "단검");
		thingsCard[2] = new Card(2, 9, "랜치");
		thingsCard[3] = new Card(2, 10, "권총");
		thingsCard[4] = new Card(2, 11, "촛대");
		thingsCard[5] = new Card(2, 12, "파이프");
	}

	public ThingsCards() {
	}

	public ThingsCards(Card[] thingsCard) {
		this.thingsCard = thingsCard;
	}

	public Card[] getThingsCard() {
		return thingsCard;
	}

	public void setThingsCard(Card[] thingsCard) {
		this.thingsCard = thingsCard;
	}

}