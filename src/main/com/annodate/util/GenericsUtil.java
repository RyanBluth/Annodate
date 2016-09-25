package com.annodate.util;

public class GenericsUtil {

    @SuppressWarnings("unchecked")
    public static<T> int getGenericArrayLength( T arr ){
        if(arr instanceof int[]){
            return ((int[]) arr).length;
        }else if(arr instanceof long[]){
            return ((long[]) arr).length;
        }else if(arr instanceof float[]){
            return ((float[]) arr).length;
        }else if(arr instanceof double[]){
            return ((double[]) arr).length;
        }else if(arr instanceof boolean[]){
            return ((boolean[]) arr).length;
        }else if(arr instanceof byte[]){
            return ((byte[]) arr).length;
        }else if(arr instanceof char[]){
            return ((char[]) arr).length;
        }else{
            return ((T[]) arr).length;
        }
    }
}
