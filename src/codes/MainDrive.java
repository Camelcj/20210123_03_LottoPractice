package codes;

import java.util.Scanner;

public class MainDrive {

	// 깃허브 연동 프로젝트
	public static void main(String[] args) {
		
		//미리 당첨번호를 설정.
		int[] winNumbers = {9, 18, 19, 30, 34, 40};
		
		//보너스번호 : 5개 맞춘 경우에만 활용
		int bonusNum = 20;
		
				

		Scanner scan = new Scanner(System.in);
		// 6개의 로또 숫자를 저장할 배열

		int[] myLottoNums = new int[6];

		// 숫자입력
		for (int i = 0; i < myLottoNums.length; i++) {

			// for - 각각의자리에 맞게 숫자를 대입하도록 하는 역할.
			// 올바른 숫자를 넣을 때까지 반복

			while (true) {

				System.out.print((i + 1) + "번째 로또 번호를 입력하세요 : ");
				int input = scan.nextInt();
				// 입력해도 되는 숫자인지? 검사하고 결과가 OK일때만 입력받은 숫자를 배열에 저장
				// 검사 1. 입력 받은 숫자가 1 ~ 45 사이의 값인가?TRUE인가 FALSE인가
				// 1 ~ 45 사이 : 1 보다는 크거나 같고, 동시에 45보다는 작거나 같다.

				boolean isRangeOk = (1 <= input && input <= 45);

				// 추가검사 : 중복인지 아닌지
				// 중복인가 ? 내가 입력한 숫자가 이미 배열안에 있다면 사용불가

				// 중복검사 결과
				// 써도 괜찮다고 했다가 - 같은 숫자 발견, 쓰면 안된다고 할 것
				boolean isDupOk = true;

				// 배열 안에 숫자를 모두 꺼내보자
				for (int myNum : myLottoNums) {
					// 입력한 값과 myNum이같은지? 같다면 중복검사 탈락
					if (input == myNum) {
						isDupOk = false;
						//중복 확정되면 for문 종료
						break;
					}
				}

				//범위도 OK고 중복여부도 통과해야한다.
				if (isRangeOk && isDupOk) {
					myLottoNums[i] = input;

					// 올바른 결과가 들어 왔으면 - while문을 종료
					// 다음 자리의 숫자를 받으러 이동
					break;
				}

				else if(!isRangeOk){
					//범위 검사에 실패를 했다면
					System.out.println("1 ~ 45의 숫자로만 입력가능합니다.");
				}
				
				else {
					//범위 검사는 맞았다면
					System.out.println("이미 입력된 번호입니다");
					System.out.println("다른 숫자로 입력을 해주세요");
				}

			}

			// 입력 받은 숫자를 배열에 저장한다

		}

		// 저장된 값을 출력

//응용문제 2 - 입력된 값들을 작은 값으로 부터 정리하기.
	
//2-1 가로로 2개씩 자리바꿈 for - 빠른 for문
// 총 6번 이 과정을 반복하게 하는 for - 느린 for문
		
		for(int i = 0; i < myLottoNums.length; i++) {
			
			for(int j = 0; j < myLottoNums.length; j++) {
				
//ex j : 0 ,배열 0번칸 배열 1번칸 비교 - > 바꿔야한다면 바꾸자
				
				if(myLottoNums[j] > myLottoNums[j + 1]) {
					//앞의 숫자가 크다는 거 발견 서로 바꿔주자
					int backUp = myLottoNums[j];
					myLottoNums[j] = myLottoNums[j + 1];
					myLottoNums[j + 1] = backUp;
				}
			}
		}
		
		
		for (int myNum : myLottoNums) {
			System.out.println(myNum);
		}

	}

}
