package clue.controller;

import clue.model.vo.Player;
import clue.model.vo.card.BonusCards;
import clue.model.vo.card.Card;

public class BonusCardEfect {
	private Player player = new Player();
	private BonusCards bonus;

	public void bonusCards(BonusCards bonus) {
		this.bonus = bonus;
		drawCard();
	}

	public void drawCard() {
		//카드뽑는 랜덤수
		int rnd = (int)(Math.random()*13+22);
		//카드가 있는지 채크
		if(rnd == bonus.getCardNum()) {
			switch(rnd) {
			case 22 :
			case 23 : oneMoreGuess(); break;
			case 24 : 
			case 25 : otherCardOpen(); break;
			case 26 : 
			case 27 : otherCardSteal(); break;
			case 28 : 
			case 29 : oneMorePlay(); break;
			case 30 : 
			case 31 : dicePlus(); break;
			case 32 : 
			case 33 : 
			case 34 : movePlace(); break;
			}
		}
	}

	/**
	 * 한번 더 추리
	 */
	public void oneMoreGuess() {

	}

	/**
	 * 다른 사람의 카드 한 장을 공개
	 */
	public void otherCardOpen() {

	}

	/**
	 * 카드 엿보기
	 */
	public void otherCardSteal() {

	}

	/**
	 * 차례를 한 번 더 진행
	 */
	public void oneMorePlay() {

	}

	/**
	 * 나온 주사위+6
	 */
	public void dicePlus() {

	}

	/**
	 * 원하는 장소로 이동
	 */
	public void movePlace() {

	}
}
