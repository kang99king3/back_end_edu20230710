package hk.edu20230808.day12_2;

//Card 클래스가 카드 한장을 의미함
public class Card {

	//카드를 만들기 위한 필드를 선언한다.
	public static final String[] DECK = {"♠","♣","◆","♥"};
	public static final String[] STECK 
	 = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};
	
	//카드 한장의 대한 정보[그림+숫자]
	private String card;// "♥5" 이런 형태로 저장됨
	
	public Card() {
		init();
	}
	
	//카드 한장 만드는 메서드
	public void init() {
		int a=(int)(Math.random()*DECK.length);//0~3까지 숫자가 랜덤하게 생성됨
		int b=(int)(Math.random()*STECK.length);//0~12사이의 숫자 랜덤생성
		card=DECK[a]+STECK[b];
	}

	public String getCard() {
		return card;
	}
	
	@Override
	public String toString() {
		return "["+card+"]";
	}
	
	// card.equals(card2)
	@Override
	public boolean equals(Object obj) {
		boolean isS=false;
		Card cd=(Card)obj;
		//현재 클래스의 card(맴버필드)와 비교하려는 Card객체의 card(맴버필드)를 비교함
		if(this.card.equals(cd.getCard())) {
			isS=true;
		}
		return isS;
	}
	
	//equals()를 오버라이딩하면 hashcode()도 오버라이딩해야 된다.
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.card.hashCode()+137;
	}
}








