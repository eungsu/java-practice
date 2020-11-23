package kr.co.jhta.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 키보드 입력을 읽어오는 유틸메소드를 제공한다.
 * @author eungsu@me.com
 *
 */
public class Keyboard {

	private static BufferedReader reader = null;
	static {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/**
	 * 키보드입력을 읽어서 문자열로 반환한다.
	 * @return 문자열
	 */
	public static String nextString() {
		try {
			return reader.readLine();
		} catch (Exception e) {
			return "";
		}
	}
	
	/**
	 * 키보드입력을 읽어서 정수로 반환한다.
	 * @return 정수
	 */
	public static int nextInt() {
		try {
			return Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			return 0;
		} 
	}
	
	/**
	 * 키보드입력을 읽어서 정수로 반환한다.
	 * @return 정수
	 */
	public static long nextLong() {
		try {
			return Long.parseLong(reader.readLine());
		} catch (Exception e) {
			return 0L;
		}
	}
	
	/**
	 * 키보드입력을 읽어서 실수로 반환한다.
	 * @return 실수
	 */
	public static double nextDouble() {
		try {
			return Double.parseDouble(reader.readLine());
		} catch (Exception e) {
			return 0.0;
		}
	}
}
