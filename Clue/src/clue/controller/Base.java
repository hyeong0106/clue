package clue.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import clue.model.vo.Player;
import clue.model.vo.card.Card;
import clue.model.vo.card.PersonCards;
import clue.model.vo.card.PlaceCards;
import clue.model.vo.card.ThingsCards;

public class Base {
	private Player[] player = new Player[6];
	private int max;
	private HashMap<Integer, Card> playingCards;// 플레이어들에게 분배할 카드
	private int rnd;// 랜덤 숫자
	private Card[] card; // 전체카드
	private String murderCards; // 범죄카드(정답 3장)

	public Base() {
	}

	/**
	 * 시작!
	 */
	public Base(Player[] player) {
		this.player = player;
		starterChoice(); // 주사위높은 플레이어 1명 뽑기
		setStartNumber();
		muderCards();
		shareCards();
		ComCardInfo();
		MyCard();
	}

	/**
	 * 시작순서 정하기 1. 주사위 높은 플레이어 뽑기
	 */
	public void starterChoice() {
		int count = 0;
		while (count < player.length) {
			int ran = (int) (Math.random() * 6 + 1);
			player[count].setStartDice(ran); // 시작순서정하기
			count++;
		}
		max = Integer.MIN_VALUE; // 시계방향으로 1등만구하기
		for (int i = 0; i < player.length; i++) {
			if (player[i].getStartDice() > max) {
				max = player[i].getStartDice();
			} else if (player[i].getStartDice() == max) {
				starterChoice();
			}
		}
	}

	/**
	 * 시작순서 정하기 2. 주사위 높은 플레이어부터 순차적으로 시작
	 */
	public void setStartNumber() {
		int startNum = 0;
		int check = 0;
		for (int i = 0; i < player.length; i++) {
			if (player[i].getStartDice() == max) {
				player[i].setStartPlayer(startNum++);
				player[i].setTurn(true);
				check = i;
				break;
			}
		}
		switch (check) {
		case 0:
			for (int i = 1; i < player.length; i++)
				player[i].setStartPlayer(startNum++);
			break;
		case 1:
			for (int i = 2; i < player.length; i++)
				player[i].setStartPlayer(startNum++);
			player[0].setStartPlayer(startNum);
			break;
		case 2:
			for (int i = 3; i < player.length; i++)
				player[i].setStartPlayer(startNum++);
			for (int i = 0; i < check; i++)
				player[i].setStartPlayer(startNum++);
			break;
		case 3:
			for (int i = 4; i < player.length; i++)
				player[i].setStartPlayer(startNum++);
			for (int i = 0; i < check; i++)
				player[i].setStartPlayer(startNum++);
			break;
		case 4:
			for (int i = 5; i < player.length; i++)
				player[i].setStartPlayer(startNum++);
			for (int i = 0; i < check; i++)
				player[i].setStartPlayer(startNum++);
			break;
		case 5:
			for (int i = 0; i < check; i++)
				player[i].setStartPlayer(startNum++);
			break;
		}

	}

	/**
	 * 정답 카드들을 숨기는 메소드
	 */
	public void muderCards() {
		playingCards = new HashMap<>();
		// 장소카드 1장 숨기기
		PlaceCards placeC = new PlaceCards();
		card = placeC.getPlaceCard();
		rnd = (int) (Math.random() * 9);
		murderCards = card[rnd].getName() + "에서 ";
		for (int i = 0; i < card.length; i++) {
			if (i == rnd)
				continue;

			playingCards.put(card[i].getCardNum(), card[i]);
		}

		// 인물카드 1장 숨기기
		PersonCards personC = new PersonCards();
		card = personC.getPersonCard();
		rnd = (int) (Math.random() * 6);
		murderCards += card[rnd].getName() + "이(가) ";
		for (int i = 0; i < card.length; i++) {
			if (i == rnd)
				continue;

			playingCards.put(card[i].getCardNum(), card[i]);
		}

		// 도구카드 1장 숨기기
		ThingsCards thingsC = new ThingsCards();
		card = thingsC.getThingsCard();
		rnd = (int) (Math.random() * 6);
		murderCards += card[rnd].getName() + "(으)로 살인을 함";
		for (int i = 0; i < card.length; i++) {
			if (i == rnd)
				continue;

			playingCards.put(card[i].getCardNum(), card[i]);
		}

	}

	/**
	 * 플레잉카드를 플레이어 들에게 분배하는 메소드
	 */
	public void shareCards() {
		int num = 0;
		int playerNum = 0;
		int[] check = new int[playingCards.size()];
		Set<Integer> check2 = playingCards.keySet();
		Set<Card> shareSet = new HashSet<>();

		share: while (playerNum < player.length) {
			rnd = (int) (Math.random() * 21 + 1);
			for (int i = 0; i < playingCards.size(); i++) {
				if (check[i] == rnd)
					continue share;
			}
			for (int key : check2) {
				if (key == rnd) {
					check[num++] = rnd;
					shareSet.add(playingCards.get(rnd));
				}
			}
			if (shareSet.size() == 3) {
				Set<Card> share = new HashSet<>();
				share.addAll(shareSet);
				player[playerNum++].setCardList(share);
				shareSet.clear();
			}
		}
	}

	// 전체카드정보 담기
	public void ComCardInfo() {
		PersonCards person = new PersonCards();
		PlaceCards place = new PlaceCards();
		ThingsCards things = new ThingsCards();

		card = person.getPersonCard();
		for (int i = 0; i < player.length; i++) {
			for (int j = 0; j < card.length; j++) {
				player[i].getPersonInfo().add(card[j].getName());
			}

		}
		card = place.getPlaceCard();
		for (int i = 0; i < player.length; i++) {
			for (int j = 0; j < card.length; j++) {
				player[i].getPlaceInfo().add(card[j].getName());
			}

		}
		card = things.getThingsCard();
		for (int i = 0; i < player.length; i++) {
			for (int j = 0; j < card.length; j++) {
				player[i].getThingsInfo().add(card[j].getName());
			}

		}

	}

	// 내 카드 String 타입으로 저장
	public void MyCard() {
		for (int i = 0; i < player.length; i++) {
			Iterator it = player[i].getCardList().iterator();

			Card[] card = new Card[3];
			int num = 0;
			while (it.hasNext()) {
				card[num] = (Card) it.next();
				player[i].getMyCard()[num] = card[num].getName();
				num++;
			}

		}
	}

	public String getMurderCards() {
		return murderCards;
	}

	public void setMurderCards(String murderCards) {
		this.murderCards = murderCards;
	}

}
