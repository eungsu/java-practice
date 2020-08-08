package com.example;

/*
문제 설명
수지는 자신의 아들이 어떤 몹쓸 친구들이랑 어울리는지 걱정을 하는 엄마다. 
아들은 오락실에서 보내는 시간을 제외하고, 친구들과 암호화 된 메시지 String message를 주고 받으면서 통신을 한다. 
수지는 아들이 친구들과 무슨 이야기를 하는지 알고 싶어한다.

수지는 아이들이 사용하는 암호 라이브러리를 문자열의 배열 형태로 일부 확보 했다. 
각 암호 라이브러리 String[] library의 요소는 “X Y”형태로 되어있는데, 
여기서 X는 암호화 할 문자이고, Y는 “.”과 “-“로 표현된 암호이다. 
아이들이 암호를 적을 때 각 문자를 암호로 변환하고 띄어쓰기로 암호화된 문자를 구분한다. 
만약, “O”가 “---”로 표현되고, “S”가 “…”으로 표현된다면, “SOS”는 “… --- …”로 암호화가 되는 식이다.

안타깝게도, 수지는 암호 라이브러리를 전부 확보하지 못했다. 
해독 할 수 없는 일부 문자에 대해서는 “?”로 대체하기로 했다 (수지는 똑똑하기 때문에 대충 유추가 가능할지도 모른다). 
암호화된 문자열과 라이브러리를 이용하여 복호화한 문자열을 리턴하시오.

참고 / 제약 사항
암호 라이브러리의 “X Y”에서 X는 대문자 알파벳이며, Y는 “.”과 “-“로만 이루어져 있다.
암호 라이브러리의 “X Y”에서 Y 중복은 없지만, X의 중복은 있을 수 있다.
Message의 길이는 1이상 50이하다.
Message는 “-“, “.”, “ “로만 이루어져 있다.
Message는 공백으로 시작하거나 공백으로 끝나지 않는다.

테스트 케이스
String[] library = {"O ---","S ..."}
String message = "... --- ..."리턴(정답): "SOS"
문제 설명에 포함된 예시.

String[] library = {"O ---"}
String message = "... --- ..."리턴(정답): "?O?"
이번에 암호 라이브러리에 S가 없음으로 “---“는 “?”로 대채한다
*/

import java.util.*;

public class Exam01{
    public static void main(String []args){
         // 암호화 라이브러리
        String[] library = {"O ---", "S ..."};
        // 획득된 암호문
        String message = "... --- ...";
        
        // 암호화라이브러리를 key:value로 저장하는 HashMap
        // key      value
        // ...      S
        // ---      O
        // 와 같은 형태로 저장
        Map<String, String> map = new HashMap<String, String>();
        
        for (String str : library) {
            String[] items = str.split(" ");
            map.put(items[1], items[0]);
        }
        
        // 획득된 암호문을 공백을 기준으로 자른다.
        String[] messageItems = message.split(" ");
        
        // 암호문을 해독해서 담는 StringBuilder객체생성
        StringBuilder result = new StringBuilder();
        
        // 암호문에서 ..., ---, ...를 하나씩 꺼낸다.
        for (String item : messageItems) {
            // Map객체에 암호문에 해당하는 key가 존재하는지 체크한다.
            if (map.containsKey(item)) {
                // key이 존재하면 key에 해당하는 valu를 가져와서 result에
                // 추가한다
                result.append(map.get(item));
            } else {
                // key가 존재하지 않으면
                // result에 ?를 추가한다.
                result.append("?");
            }
        }
        
        System.out.println("입력 : " + message);
        System.out.println("출력 : " + result.toString());
    }
}
