package com.zcc.study.utils.util;

/**
 * @author 赵成成
 * @version 1.0
 * @Description Java基础练习类
 * @date
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(3/2);
        System.out.println(newReverse("abcdefghijklmn", 3));
    }

    /**
     * 字符串反转
     * @return
     */
    private static StringBuilder newReverse(String str,int k){
        //将str转换为StringBuilder类型变量，方便使用工具方法
        //存储已经反转的字符串
        StringBuilder stringBuilder=new StringBuilder(str);
        //获取字符串长度
        int strLength=str.length();
        //求取字符串长度整除k的值
        int divide=strLength/k;
        //求模取余
        int remainder=strLength%k;
        //排除特殊情况，字符串长度为0,divide，remainder均为0
        if (strLength==0){
            System.out.println("字符串长度不能为零");
            return null;
        }
        //如果余数为零，说明字符串长度刚好是k的整倍数,divide为整数，按照要求反转
        if (remainder==0){
            //如果divide为偶数，则按照要求反转
            if (divide%2==0){
                for(int i=2;i<=divide;i+=2){
                    //截取需要反转的字符串
                    String beforeReverseString = str.substring((i - 1) * k , i * k);
                    //反转
                    StringBuilder afterReverseString = new StringBuilder(beforeReverseString).reverse();
                    //将反转后的局部字符串替换到原来字符串
                    stringBuilder.replace((i - 1) * k, i * k, new String(afterReverseString));
                }
            }else{
                //如果divide为奇数，则最后一倍k值的字符串也要反转
                for(int i=2;i<=divide-1;i+=2){
                    //截取需要反转的字符串
                    String beforeReverseString = str.substring((i - 1) * k, i * k );
                    //反转
                    StringBuilder afterReverseString = new StringBuilder(beforeReverseString).reverse();
                    //将反转后的局部字符串替换到原来字符串
                    stringBuilder=new StringBuilder(stringBuilder).replace((i - 1) * k, i * k, new String(afterReverseString));
                }
                //截取需要反转的字符串
                String beforeReverseString = str.substring((divide - 1) * k, divide * k);
                //反转
                StringBuilder afgerReverseString = new StringBuilder(beforeReverseString).reverse();
                //将反转后的局部字符串替换到原来字符串
                stringBuilder.replace((divide - 1) * k, divide * k, new String(afgerReverseString));
            }
        }else{
            //如果余数remainder不为零，说明字符串长度不是k的整倍数,此时divide仍为为整数，按照要求反转
            //如果divide为偶数，则按照要求替换之后，还有remainder个字符需要反转
            if (divide%2==0){
                for(int i=2;i<=divide;i+=2){
                    //截取需要反转的字符串
                    String beforeReverseString = str.substring((i - 1) * k, i * k);
                    //反转
                    StringBuilder afgerReverseString = new StringBuilder(beforeReverseString).reverse();
                    //将反转后的局部字符串替换到原来字符串
                    stringBuilder.replace((i - 1) * k, i * k, new String(afgerReverseString));
                }
                //将余下的字符串反转
                //截取需要反转的字符串
                String beforeReverseString = str.substring(divide*k, strLength);
                //反转
                StringBuilder afgerReverseString = new StringBuilder(beforeReverseString).reverse();
                //将反转后的局部字符串替换到原来字符串
                stringBuilder.replace(divide*k, strLength, new String(afgerReverseString));
            }else{
                //如果divide为奇数，则按照要求替换之后，还有k个字符需要反转
                for(int i=2;i<=divide-1;i+=2){
                    //截取需要反转的字符串
                    String beforeReverseString = str.substring((i - 1) * k , i * k);
                    //反转
                    StringBuilder afgerReverseString = new StringBuilder(beforeReverseString).reverse();
                    //将反转后的局部字符串替换到原来字符串
                    stringBuilder.replace((i - 1) * k, i * k, new String(afgerReverseString));
                }
                //将余下的字符串反转
                //截取需要反转的字符串
                String beforeReverseString = str.substring((divide-1)*k, divide*k);
                //反转
                StringBuilder afgerReverseString = new StringBuilder(beforeReverseString).reverse();
                //将反转后的局部字符串替换到原来字符串
                stringBuilder.replace((divide-1)*k, divide*k, new String(afgerReverseString));
            }

        }
        return stringBuilder;
    }
}
