package com.example;

import java.util.Scanner;

/*
문제 설명
    야구게임 만들기
    1~9 까지의 수 중에서 임의의 숫자 3개를 가진 배열이 있다.(중복은 허용하지 않는다.)
    사용자로부터 숫자 3개를 입력받아서 배열에 저장한다.
    사용자가 입력한 숫자와 임의의 숫자를 비교해서
    동일한 위치에 동일한 숫자가 있는 경우 Strike
    동일한 위치는 아니지만 동일한 숫자가 존재하는 경우 Ball로 판정한다.
    예)
        임의의 숫자 [3, 7, 4] 사용자가 입력한 숫자 [1, 2, 3]  출력값은 "0S1B"이다.
        임의의 숫자 [3, 7, 4] 사용자가 입력한 숫자 [3, 4, 5]  출력값은 "1S1B"이다.
    최대 10회까지만 입력할 수 있다.
    출력값이 "3S0B" 인 경우 사용자가 숫자를 모두 맞힌 것이다.

*/
public class Exam03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] secret = new int[3];
        int[] inputNumbers = new int[3];

        for (int i=0; i<secret.length; i++) {
            int randomNumber = (int) (Math.random()*9 + 1);

            boolean isExist = false;
            for (int j=0; j<i; j++) {
                if (randomNumber == secret[j]) {
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                secret[i] = randomNumber;
            } else {
                i--;
            }
        }

        int tryCount = 1;
        while (true) {
            if (tryCount > 10) {
                System.out.println("시도 횟수가 10회를 초과하였습니다.");
                break;
            }

            int strikeCount = 0;
            int ballCount = 0;

            System.out.print("첫번째 숫자를 입력하세요: ");
            inputNumbers[0] = scanner.nextInt();
            System.out.print("두번째 숫자를 입력하세요: ");
            inputNumbers[1] = scanner.nextInt();
            System.out.print("세번째 숫자를 입력하세요: ");
            inputNumbers[2] = scanner.nextInt();

            for (int i=0; i<inputNumbers.length; i++) {
                for (int j=0; j<secret.length; j++) {
                    if (inputNumbers[i] == secret[j]) {
                        if (i == j) {
                            strikeCount++;
                        } else {
                            ballCount++;
                        }
                    }

                }
            }

            System.out.println(strikeCount + "S" + ballCount + "B");
            if (strikeCount == 3) {
                System.out.println("정답입니다.");
                break;
            } else {
                tryCount++;
            }

        }

        scanner.close();
    }
}
