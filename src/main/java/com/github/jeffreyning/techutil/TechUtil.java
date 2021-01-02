package com.github.jeffreyning.techutil;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.BiFunction;


/**
 * @author ninghao
 */
public class TechUtil {
    public static<T> String pn(ParseFun<T, Object> parseFun) throws Exception {
        Method writeReplace = parseFun.getClass().getDeclaredMethod("writeReplace");
        writeReplace.setAccessible(true);
        Object sl = writeReplace.invoke(parseFun);
        SerializedLambda serializedLambda = (SerializedLambda) sl;
        String methodName = serializedLambda.getImplMethodName();
        if (methodName.startsWith("is")) {
            methodName = methodName.substring(2);
        } else {
            if (!methodName.startsWith("get") && !methodName.startsWith("set")) {
                throw new IllegalArgumentException("Error parsing property name '" + methodName
                        + "'.  Didn't start with 'is', 'get' or 'set'.");
            }
            methodName = methodName.substring(3);
        }
        if (methodName.length() == 1 || (methodName.length() > 1 && !Character
                .isUpperCase(methodName.charAt(1)))) {
            methodName = methodName.substring(0, 1).toLowerCase(Locale.ENGLISH) + methodName.substring(1);
        }
        return methodName;
    }
    public static <T> void forEach(Iterable<? extends T> elements, BiFunction<Integer, ? super T, CMD> action) {
        Objects.requireNonNull(elements);
        Objects.requireNonNull(action);
        int index = 0;
        for (T element : elements) {
            index++;
            CMD cmd=action.apply(index-1, element);
            if(cmd.isBreak()){
                break;
            }
        }
    }

    public static <T> void forEach(Map<String, T> map, BiFunction<Integer, Map.Entry<String, T>, CMD> action) {
        Objects.requireNonNull(map);
        Objects.requireNonNull(action);
        Iterable<Map.Entry<String,T>> elements=map.entrySet();
        int index = 0;
        for (Map.Entry<String, T> element : elements) {
            index++;
            CMD cmd=action.apply(index-1, element);
            if(cmd.isBreak()){
                break;
            }
        }
    }

    public static <T> void forEach(Object[] arr, BiFunction<Integer, ? super T, CMD> action) {
        Objects.requireNonNull(arr);
        Objects.requireNonNull(action);
        List<T> list= (List<T>) Arrays.asList(arr);
        Iterable<T> elements=list;
        int index = 0;
        for (T element : elements) {
            index++;
            CMD cmd=action.apply(index-1, element);
            if(cmd.isBreak()){
                break;
            }
        }
    }


}
