package com.ruoyi.common.utils;

/**
 * 验证码工具类
 * @author Li Dehuan
 * @date 2019年7月10日
 *
 */
public class VeriCdoeUtils {

	public static char[] numbers = {'0', '1', '2', '3', '4','5','6','7','8','9'};
	public static char[] chs = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
								'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
								's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	/**
	 * 生成简单易记的验证码
	 * @return
	 */
	public static String getSimpleCode(){
		
		return getSimpleCode(6);
	}
	
	
	/**
	 * 生成简单易记的验证码
	 * @param length 长度
	 * @return
	 */
	public static String getSimpleCode(int length){
		
		StringBuffer code = new StringBuffer();
		
		int index = (int)(Math.random() * numbers.length);
		
		code.append(numbers[index]);
		
		countCode(numbers, code, length, index);
		
		return code.toString();
	}
	
	
	private static void countCode(char[] source, StringBuffer code,int length, int index){
		
		if(length == code.length()){
			return;
		}
		
		int i = (int)(Math.random() * 3) + index - 1;
		
		//临界值
		if(i < 0){
			i = source.length - 1;
			
		}else if(i >= source.length){
			i = 0;
		}
		
		char c = numbers[i];
		
		code.append(c);
		
		if(c == source[index]){

			if(length == code.length()){
				return;
			}
			
			i = (int)(Math.random() * numbers.length);
			code.append(numbers[i]);
			
			countCode(source, code, length, i);
		}else{
			
			countCode(source, code, length, i);
		}
	
	}
	
	public static void main(String[] args) {
		
		System.out.println(getSimpleCode());
	}
}
