package clue.model.vo.card;
public class BonusCards extends Card{
    // 미궁카드
    private Card[] bonusCard;
    {
        bonusCard[0] = new Card(4, 22, "한번 더 추리");
        bonusCard[1] = new Card(4, 23, "한번 더 추리");
        bonusCard[2] = new Card(4, 24, "다른 사람의 카드 한 장을 공개");
        bonusCard[3] = new Card(4, 25, "다른 사람의 카드 한 장을 공개");
        bonusCard[4] = new Card(4, 26, "카드 엿보기");
        bonusCard[5] = new Card(4, 27, "카드 엿보기");
        bonusCard[6] = new Card(4, 28, "차례를 한 번 더 진행");
        bonusCard[7] = new Card(4, 29, "차례를 한 번 더 진행");
        bonusCard[8] = new Card(4, 30, "나온 주사위+6");
        bonusCard[9] = new Card(4, 31, "나온 주사위+6");
        bonusCard[10] = new Card(4, 32, "원하는 장소로 이동");
        bonusCard[11] = new Card(4, 33, "원하는 장소로 이동");
        bonusCard[12] = new Card(4, 34, "원하는 장소로 이동");
    }
    
    public BonusCards() {}
    
    public BonusCards(Card[] bonusCard) {
        this.bonusCard = bonusCard;
    }
    public Card[] getBonusCard() {
        return bonusCard;
    }
    public void setBonusCard(Card[] bonusCard) {
        this.bonusCard = bonusCard;
    }
    
    
}
