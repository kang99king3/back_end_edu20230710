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
			System.out.println(sumCol(i));//가로방향 합 출력
			System.out.println();
		}
		for (int i = 0; i < magic.length; i++) {
			System.out.print(sumRow(i)+"\t"); //세로합 출력
		}
		System.out.println("\n대각선의 합:"+sumDia()+","+sumRevDia());
		System.out.println("마방진 확인:"+(isCheck()?"마방진 증명":"마방진 실패"));
	}
	
	//row (세로방향)합
	public int sumRow(int j) {
		int tot=0;
		for (int i = 0; i < magic.length; i++) {
			tot+=magic[i][j];
		}
		return tot;
	}
	
	//col (가로방향)합
	public int sumCol(int j) {
		int tot=0;
		for (int i = 0; i < magic.length; i++) {
			tot+=magic[j][i];
		}
		return tot;
	}
	//왼쪽->오른쪽 대각선의 합
	public int sumDia() {
		int tot=0;
		for (int i = 0; i < magic.length; i++) {
			tot+=magic[i][i];
		}
		return tot;
	}
	//오른쪽->왼쪽 대각선의 합
	public int sumRevDia() {
		int tot=0;
		for (int i = 0; i < magic.length; i++) {
			tot+=magic[i][magic.length-1-i];
		}
		return tot;
	}
	//합이 같은지 체크
	public boolean isCheck() {
		boolean isC=true;
		int n=magic.length;
		int [] ma=new int [2*n+2];
		
		for (int i = 0; i < n; i++) {
			ma[i]=sumRow(i);// 0 1 2
			ma[i+n]=sumCol(i);// 3 4 5
		}
		ma[2*n]=sumDia();
		ma[2*n+1]=sumRevDia();
		
		for (int i = 1; i < ma.length; i++) {
			if(ma[0]!=ma[i]) {
				isC=false;
				break;
			}
		}
		
		return isC;
	}
}














