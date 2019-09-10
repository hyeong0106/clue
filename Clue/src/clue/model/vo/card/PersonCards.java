package clue.model.vo.card;

public class PersonCards extends Card {
	// 인물카드
	private Card[] personCard = new Card[6];
	{
		personCard[0] = new Card(1, 1, "스칼렛");
		personCard[1] = new Card(1, 2, "머스타드");
		personCard[2] = new Card(1, 3, "화이트");
		personCard[3] = new Card(1, 4, "그린");
		personCard[4] = new Card(1, 5, "피콕");
		personCard[5] = new Card(1, 6, "플럼");
	}

	public PersonCards() {

	}

	public PersonCards(Card[] personCard) {
		this.personCard = personCard;
	}

	public Card[] getPersonCard() {
		return personCard;
	}

	public void setPersonCard(Card[] personCard) {
		this.personCard = personCard;
	}

}