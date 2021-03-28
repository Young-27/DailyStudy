package baekJoonOnlineJudge;

import java.util.Scanner;

//1000번문제
public class Baek {
	
	public void b1000() {
		
		 Scanner sc = new Scanner(System.in); 
		 int a,b; 
		 a = sc.nextInt(); 
		 b = sc.nextInt();
		   
		 System.out.println(a+b);
	}	
	
	
	//2739
	//N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.
	//입력:첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 9보다 작거나 같다.
	//출력:출력형식과 같게 N*1부터 N*9까지 출력한다.
	
	public void b2739() {
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();
		
		if(N>=1 && N<=9) {
			for(int i=1;i<=9;i++)
				System.out.printf("%d * %d = %d\n",N,i,N*i);

		}
	
		
		
	}
	
	// 10950
	// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
	// 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
	// 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
	// 각 테스트 케이스마다 A+B를 출력한다.
	
	public void b10950() {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
	
		for(int i=1; i<=T; i++) {	
			
			int a; 
			int b;
			
			a=sc.nextInt(); b=sc.nextInt();
			
			if(a > 0 && b < 10) {				
				System.out.println(a+b);
			}
		}
		
	}
	
	// 8393
	// n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
	// 첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
	// 1부터 n까지 합을 출력한다.
	
	public void b8393() {
		
		Scanner sc = new Scanner(System.in);
		int n;
		n=sc.nextInt();
		int i;
		int sum = 0;
		
		if(n>=1 && n<=10000) {
			
			for(i=1; i<=n; i++) {
				
				sum += i;
				
			}
			System.out.println(sum);
		}
	}
	
	// 2438
	// 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
	// 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
	// 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
	
	public void b2438() {
		
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();
		
				
		for(int i=1; i<=N; i++) {
			
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();	
		}
		
		
	}
	
	//10818
	//N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
	//첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 
	//둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 
	//모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
	//첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
	
	public void b10818() {
		
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int[] arr = new int[n];
		int max = -1000000;
		int min = 1000000;
		
		for(int i=0; i<arr.length; i++) {
			
			arr[i] = sc.nextInt();
			
		}
		
		for(int i=0; i<arr.length; i++) {
			
			
			if(max<arr[i]) {
				max = arr[i];
				}
			if(min>arr[i]) {
				min = arr[i];
				}
			}
			System.out.println(min + " " + max);
		}
		
		
	
	
	//1001
	//두 정수 A와 B를 입력받은 다음, A-B를 출력하는 프로그램을 작성하시오.
	//첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
	//첫째 줄에 A-B를 출력한다.
	
	public void b1001() {
		
		Scanner sc = new Scanner(System.in);
		int a,b;
		a = sc.nextInt();
		b = sc.nextInt();
		
		System.out.println(a-b);
		
	}
	
	// 가위바위보 게임 만들기
	// 참고하지말고 고민해보기!!
	
	public void rockPaperScissors() {
		
		Scanner sc = new Scanner(System.in);
		
		
		String computer = "";
		
		int count = 0;
		int win = 0;
		int lose = 0;
		int draw = 0;
		
		while (true) {
			System.out.print("가위바위보(종료하려면 exit) : ");
			String user = sc.nextLine();
			
			int result = (int)(Math.random() * 3);
			
			switch(result) {
			case 0 : computer = "바위";
			case 1 : computer = "가위";
			case 2 : computer = "보";
			}
			
			
			
		
			if (user.equals("바위") || user.equals("가위") || user.equals("보")) {
				
				System.out.println("컴퓨터는 " + computer + "를 냈습니다.");
				
				if (user.equals(computer)) {
					System.out.println("비겼습니다.");
					draw++;
					count++;
					
				} else if (user.equals("바위")) {
					if (computer.equals("가위")) {
						System.out.println("축하합니다. 이겼습니다.");
						lose++;
					} else {
						System.out.println("졌습니다.");
						win++;
					}
					count++;
				} else if (user.equals("가위")) {
					if (computer.equals("보")) {
						System.out.println("축하합니다. 이겼습니다.");
						lose++;
					} else {
						System.out.println("졌습니다.");
						win++;
					}
					count++;
				} else if (user.equals("보")) {
					if (computer.equals("바위")) {
						System.out.println("축하합니다. 이겼습니다.");
						lose++;
					} else {
						System.out.println("졌습니다.");
						win++;
					}
					count++;
				}
			} else if (user.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨네요. 다시 입력해주세요.");
				continue;
			}
		}
		
		System.out.println(count + "전 " + win + "승 " + draw + "무 " + lose + "패");
		
		
		
	}
	
	
	public void upAndDown() {
		
		int computer = (int)(Math.random() * 100 + 1);
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		
		while(true) {
		
			System.out.println("숫자(1~100) 맞혀봐~~! : ");
			int user = sc.nextInt();
			
			if(user >= 1 && user <= 100) {
				if(user == computer) {
					System.out.println("맞혔습니다!");
					count++;
					break;
					
				}else if(user > computer){
					System.out.println("down!! 더 낮춰보삼");
					count++;
					continue;
					
				}else {
					System.out.println("up!! 더 올려보삼");
					count++;
					continue;
					
				}
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세욥!!");
				continue;
			}
		}
		System.out.println(count + "번만에 맞히셨네욥ㅎㅎ");
	}
	
	// 사용자에게 한 개의 정수를 입력받고
	// 1부터 입력 받은 수까지 홀수/짝수를 나눠서
	// 홀수면 박, 짝수면 수 출력
	
	// 단, 입력받은 수가 양수가 아니면 "양수가 아닙니다" 출력
	
	// 예시 ) 4 입력시  -->  박수박수 출력
	
	public void compExample() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if (num > 0) {

			for (int i = 0; i < num; i++) {

				if (i % 2 == 0) {
					System.out.print("박");
				} else {
					System.out.print("수");
				}
			}

		} else {
			System.out.println("양수가 아닙니다.");
		}
	
	}
	
	
	public void b2_10818() {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int min = 1000000;
		int max = -1000000;
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			
			arr[i] = sc.nextInt();
			
			if(arr[i]>max) {
				max = arr[i];
			}
			
			if(arr[i]<min) {
				min = arr[i];
			}
			
		}
		
		System.out.println(min + " " + max);
	
	}
	
	public void b2562() {
		
		Scanner sc = new Scanner(System.in);
	
		int[] arr = new int[9];
		
		int max = 0;
		int count = 0;
		
		for(int i=0; i<9; i++) {
			
			arr[i] = sc.nextInt();

			
			if(arr[i]>max) {
				max = arr[i];
				count = i+1;
			}		
		}
		System.out.println(max);
		System.out.println(count);
		
		
		
	}
	
	// 2~3시간 걸리다가 다른사람 코드봄..
	// count와 sum을 for문 밖에 놓은것
	// count 까지는 생각했으나 X가 나타나면 count가 0이되는것과
	// sum = sum+count 의 식을 생각해내지 못했다.
	public void b8958() {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[n];
		
		
		
		for(int i=0; i<n; i++) {
			
			arr[i] = sc.nextLine();
			
			int sum = 0;
			int count = 0;
			
			for(int j=0; j<arr[i].length(); j++) {
				if(arr[i].charAt(j) == 'O') { // 'O'일때
					count++;
				}else { // 'X'가 나타나면
					count = 0;
				}				
				sum = sum+count;	
			}
		System.out.println(sum);
				
		}
			
	}
	
	// 2577 : 숫자의 개수
	// int를 char로 바꾸는 방법 => 숫자 + '0'
	// int를 String으로 바꾸는 함수 Integer.toString();

	public void b2577() {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = a * b * c;
		
		String result = Integer.toString(d);		
		
		int[] arr = new int[10];
		
		int count = 0;
		
		for(int i=0; i<10; i++) {	
			for(int j=0; j<result.length(); j++) {
				if(result.charAt(j) == i+'0') { 
					count++;												
				}
			}
			arr[i] = count;
			System.out.println(arr[i]);
			
			count = 0;
			
		}
		
	}
	
	// 3052 : 나머지
	
	public void b3052() {
		
		Scanner sc = new Scanner(System.in);
		
		int[] ar1 = new int[10];
		
		for(int i=0; i<10; i++) {
			
			ar1[i]=sc.nextInt();
			
		}
		
		int[] ar2 = new int[10];
		
		for(int i=0; i<10; i++) {
			
			ar2[i] = ar1[i] % 42;
			
		} 
		
		int count = 0;
		int result = 0;
		
		for(int i=0; i<10; i++) {
			
			count = 0;
			
			for(int j=i+1; j<10; j++) {
				if(ar2[i] == ar2[j]) { 
					count++;
				}
			
			}
			
			if(count == 0) {
				result++;
			}
	
		}
		
		System.out.println(result);
		
		
	}

	
	
	
	
}


