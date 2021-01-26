package codes;

import java.util.Scanner;

public class MainDrive {

	// 깃허브 연동 프로젝트
	public static void main(String[] args) {

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

				if (isRangeOk) {
					myLottoNums[i] = input;

					// 올바른 결과가 들어 왔으면 - while문을 종료
					// 다음 자리의 숫자를 받으러 이동
					break;
				}

				else {
					// 검사에 실패한 경우
					// 안내메세지도 보여주자
					System.out.println("잘못된 숫자 입니다. 다시 입력해 주세요");
				}

			}

			// 입력 받은 숫자를 배열에 저장한다

		}

		// 저장된 값을 출력

		for (int myNum : myLottoNums) {
			System.out.println(myNum);
		}

	}

}
