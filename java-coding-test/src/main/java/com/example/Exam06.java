package com.example;

import java.util.Arrays;

/*
    문제설명
    비밀지도 해석하기
    1. 지도는 한 변의 길이가  n인 정사각형 배열 형태다.
    2. 각 변은 공백(""), 벽("#")으로 구성된다.
    3. 전체 지도는 두 장의 지도를 겹쳐서 획득할 수 있다. 두 지도를 켭쳤을 때 지도1과 지도2 모두 공백인 곳은 공백으로, 지도1과 지도2중 어느 한 곳이라도 벽인 경우는 전체 지도에서도 벽이다.
    4. 지도1과 지도2는 각각 정부 배열로 암호화되어 있다.
    5. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.

    입력값
        한 변의 길이 : 5
        지도1       : [9, 20, 28, 18, 11]
        [ ][#][ ][ ][#] <--- 01001 = 9
        [#][ ][#][ ][ ] <--- 10100 = 20
        [#][#][#][ ][ ] <--- 11100 = 28
        [#][ ][ ][#][ ] <--- 10010 = 18
        [ ][#][ ][#][#] <--- 01011 = 11

        지도2       : [30, 1, 21, 17, 28]
        [#][#][#][#][ ] <--- 11110 = 30
        [ ][ ][ ][ ][#] <--- 00001 = 1
        [#][ ][#][ ][#] <--- 10101 = 21
        [#][ ][ ][ ][#] <--- 10001 = 17
        [#][#][#][ ][ ] <--- 11100 = 28

    출력값
        ["#####", "# # #", "### #", "#  ##", "#####"]
        [#][#][#][#][#]
        [#][ ][#][ ][#]
        [#][#][#][ ][#]
        [#][ ][ ][#][#]
        [#][#][#][#][#]

    입력값
        한 변의 길이 : 6
        지도1       : [46, 33, 33, 22, 31, 50]
        지도2       : [27, 56, 19, 14, 14, 10]
    출력값
        ["######", "###  #", "##  ##", " #### ", " #####", "### # "]
*/
public class Exam06 {

    public static void main(String[] args) {

        String[] answer1 = answer(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        System.out.println(Arrays.toString(answer1));

        String[] answer2 = answer(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10});
        System.out.println(Arrays.toString(answer2));

    }

    private static String[] answer(int n, int[] arr1, int[] arr2) {
        String[] answers = new String[n];
        for(int i=0; i<n; i++) {
            answers[i] = numberToText(n, arr1[i] | arr2[i]);
        }
        return answers;
    }

    private static String numberToText(int n, int num) {
        String text = Integer.toBinaryString(num).replace("0", " ").replace("1", "#");
        if (text.length() > n) {
            text = text.substring(text.length() - n);
        } else if (text.length() < n) {
            String padding = "";
            for (int i=0; i<n - text.length(); i++) {
                padding += " ";
            }
            text = padding + text;
        }
        return text;
    }
}
