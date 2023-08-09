package hk.edu20230808.day12_2;

import java.util.List;

public class CardMain {

	public static void main(String[] args) {
//		Card card=new Card();
//		Card card2=new Card();
		
//		System.out.println(card.toString()+":"+card2.toString());
//		System.out.println(card.getCard().equals(card2.getCard()));
//		System.out.println(card.equals(card2));
		
		//CardCase 클래스를 만들어서 52장 담는 List<Card> cards(맴버필드) 구현하기
		
		CardCase cardCase=new CardCase();
		List<Card> cards=cardCase.getCards();//카드 52장 가져오기
		
		for (int i = 0; i < cards.size(); i++) {
			System.out.print(cards.get(i)+"\t");
			//10장씩 줄바꿔서 출력
			if((i+1)%10==0) {
				System.out.println();//10장 출력했으면 줄바꿈
			}
		}
	}

}














