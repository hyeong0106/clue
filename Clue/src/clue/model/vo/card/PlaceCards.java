package clue.model.vo.card;

public class PlaceCards extends Card {
	// 장소카드
	private Card[] placeCard = new Card[9];
	{
		placeCard[0] = new Card(3, 13, "마당");
		placeCard[1] = new Card(3, 14, "게임룸");
		placeCard[2] = new Card(3, 15, "서재");
		placeCard[3] = new Card(3, 16, "식당");
		placeCard[4] = new Card(3, 17, "차고");
		placeCard[5] = new Card(3, 18, "거실");
		placeCard[6] = new Card(3, 19, "부엌");
		placeCard[7] = new Card(3, 20, "침실");
		placeCard[8] = new Card(3, 21, "욕실");
	}

	public PlaceCards() {
	}

	public PlaceCards(Card[] placeCard) {
		this.placeCard = placeCard;
	}

	public Card[] getPlaceCard() {
		return placeCard;
	}

	public void setPlaceCard(Card[] placeCard) {
		this.placeCard = placeCard;
	}

}