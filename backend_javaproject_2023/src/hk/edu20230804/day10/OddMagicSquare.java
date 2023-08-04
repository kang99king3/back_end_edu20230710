package hk.edu20230804.day10;

public class OddMagicSquare {

	public int [][] magic;
	
	public OddMagicSquare() {
		this.magic=new int[3][3];
	}
	
	public OddMagicSquare(int n) {
		this.magic=new int[n][n];
	}
	
	public void make() {
		int n=magic.length;
		int x=0;
		int y=n/2;// 0번째행의 중간 열 인덱스를 구함
		magic[x][y]=1;
		for (int i = 2; i <= n*n; i++) { // i값은 실제 입력되는 2~9까지의 숫자
			int tempX=x;//값을 복사해서 전달, 할당
			int tempY=y;//값을 복사해서 전달, 할당
			
			if(x-1<0) {
				x=n-1; //인덱스의 최대값을 저장한다.
			}else {
				x--;//x-1				
			}
			
			if(y-1<0) {
				y=n-1; //인덱스의 최대값을 저장한다.
			}else {
				y--;//y-1				
			}
			
			if(magic[x][y]!=0) {//이동했더니 그위치에 값이 있다면
				x=tempX+1; //원래 위치로 돌아와서 x+1
				y=tempY;   //원래 위치로 돌아온다
			}
			magic[x][y]=i;
		}
	}
	
	public void magicPrint() {
		for (int i = 0; i < magic.length; i++) {
			for (int j = 0; j < magic.length; j++) {
				System.out.print(magic[i][j]+"\t");
			}
			System.out.println();
		}
	}
}














