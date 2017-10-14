package com.yuan.comm.util;

/**
 * Produce a sequence [0..n]
 * @ClassName RangeUtil
 * @author yuan
 * @date 2017��10��14��
 * @version 1.0
 */
public class RangeUtil {

	/**
	 * ��������
	 * @MethodName range 
	 * @param n
	 * @return
	 * @author yuan
	 * @return int[]
	 */
	public static int[] range(int n){
		int[] result = new int[n];
		for(int i=0; i < n;i++){
			result[i] = i;
		}
		return result;
	}
	/**
	 * Produce a sequence [start..end]
	 * @MethodName range 
	 * @param start
	 * @param end
	 * @return
	 * @author yuan
	 * @return int[]
	 */
	public static int[] range(int start,int end){
		int sz = end - start;
		int[] result = new int[sz];
		for(int i=0; i < sz;i++){
			result[i] = start + i;
		}
		return result;
	}
	/**
	 * Produce a sequence [start..end] incrementing by step
	 * @MethodName range 
	 * @param start
	 * @param end
	 * @param step
	 * @return
	 * @author yuan
	 * @return int[]
	 */
	public static int[] range(int start,int end,int step){
		int sz = (end - start)/step;
		int[] result = new int[sz];
		for(int i=0; i < sz;i++){
			result[i] = start + (i*step);
		}
		return result;
	}
}
