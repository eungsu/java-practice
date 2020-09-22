package chap2.srp;

/**
 * 단일 책임 원칙(SRP: Single Responsibility Principle)
 * 	
 * <p>
 * 단일 책임 원칙은 쉽게 관리하고 유지보수하는 코드를 구현하는 데 도움을 주는 포괄적인 소프트웨어 개발 지침이다.
 * </p>
 * <ul>
 * 	<li>한 클래스는 한 기능만 책임진다.</li>
 * 	<li>클래스가 바뀌어야 하는 이유는 오직 하나여야 한다.</li>
 * </ul>
 * 
 * <p>
 * SRP를 적용하면 코드가 바뀌어야 하는 이유가 한 가지로 제한되므로 더 튼튼한 코드를 만들 수 있다.
 * <p>
 * chap.simple 패키지의 예제처럼 코드가 바뀌는 이유가 한 가지가 아니라면, 여러 장소에서 코드 변경이 발생하므로 유지보수가 더 어려워진다.
 * 또한, 코드를 이해하고 바꾸기 어렵게 만드는 요인이기도 하다.
 * 
 * <p>
 * 입출금 내역 분석기 프로그램에 SRP 적용하면
 * <ol>
 * 	<li>입력 읽기</li>
 * 	<li>주어진 형식의 입력 파싱</li>
 * 	<li>결과 처리</li>
 * 	<li>결과 요약 리포트</li>
 * </ol>
 * 위와 같이 여러 책임을 개별로 분리해야 한다.
*/