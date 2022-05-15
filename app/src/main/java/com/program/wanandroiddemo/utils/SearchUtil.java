package com.program.wanandroiddemo.utils;

import java.util.List;

public class SearchUtil {


    public static int commonBinarySearch(List<Integer> list, int key){
        int low = 0;
        int high =list.size()-1;
        int middle = 0;			//定义middle
        if(low > high||key > list.get(low) || key < list.get(high)){
            return -1;
        }

        while(low <= high){
            middle = (high-low)/2+low;
            if(list.get(middle) > key){
                //比关键字大则关键字在左区域
                high = middle - 1;
            }else if(list.get(middle)< key){
                //比关键字小则关键字在右区域
                low = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    public static int Search(List<Integer> list, int key){
        for (int i=0;i<list.size();i++){
            if (list.get(i)==key){
                return i;
            }
        }
        return -1;
    }

}
