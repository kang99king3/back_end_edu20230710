package hk.edu20230808.day12_2;

import java.util.ArrayList;
import java.util.List;

public class CardCase {

	//카드 52장을 담을 저장공간
	private List<Card> cards;
	
	//카드 총 장수를 구하자
	private static final int numOfCards=Card.DECK.length*Card.STECK.length;
	
	public CardCase() {
		cards=new ArrayList<>();
		shuffle();
	}
	
	//카드객체를 생성해서 cards에 담는 기능
	public void shuffle() {
		int i=0;
		while(true) {
			
			Card cc=new Card();//카드 한장이 만들어짐
			if(!cards.contains(cc)) {
				cards.add(cc);//카드 한장 넣기
				i++;				
			}
			
			if(i==numOfCards) {
				break;
			}
		}
	}

	public List<Card> getCards() {
		return cards;
	}
	
}

















