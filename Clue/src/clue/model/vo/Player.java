package clue.model.vo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import clue.model.vo.card.Card;

public class Player extends Card {
	private String name;
	private Set<Card> cardList;
	private int bonusCard;
	private int startDice;// 시작순저 정하는 주사위
	private String character; // 캐릭터
	private int startPlayer;// 시작순서
	private int dice;// 주사위값
	private boolean turn;// true or false 자신의 턴이면true 아니면false
	private int location; // 말의 위치
	private List placeInfo = new ArrayList();
	private List personInfo = new ArrayList();
	private List thingsInfo = new ArrayList();
	private String[] myCard = new String[3];
	private int score;
	public Player() {
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name+" ";
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Card> getCardList() {
		return cardList;
	}

	public void setCardList(Set<Card> cardList) {
		this.cardList = cardList;
	}

	public int getBonusCard() {
		return bonusCard;
	}

	public void setBonusCard(int bonusCard) {
		this.bonusCard = bonusCard;
	}

	public int getStartDice() {
		return startDice;
	}

	public void setStartDice(int startDice) {
		this.startDice = startDice;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public int getStartPlayer() {
		return startPlayer;
	}

	public void setStartPlayer(int startPlayer) {
		this.startPlayer = startPlayer;
	}

	public int getDice() {
		return dice;
	}

	public void setDice(int dice) {
		this.dice = dice;
	}

	public boolean getTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public List getPlaceInfo() {
		return placeInfo;
	}

	public void setPlaceInfo(List placeInfo) {
		this.placeInfo = placeInfo;
	}

	public List getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(List personInfo) {
		this.personInfo = personInfo;
	}

	public List getThingsInfo() {
		return thingsInfo;
	}

	public void setThingsInfo(List thingsInfo) {
		this.thingsInfo = thingsInfo;
	}

	public String[] getMyCard() {
		return myCard;
	}

	public void setMyCard(String[] myCard) {
		this.myCard = myCard;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		Iterator it = cardList.iterator();
		String card = "";
		while (it.hasNext()) {
			card += it.next() + " ";
		}
		return "name:" + name + " cardList:" + card + "시작순서정하기:" + startDice + " 시작순서:" + startPlayer + " 플레이어 말:"
				+ character + " 위치 :" + location;
	}

}