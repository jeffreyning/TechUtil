package com.github.jeffreyning.techutil;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.util.Locale;

/**
 * @author ninghao
 */
public class TechUtil {
    private static<T> String pn(ParseFun<T, Object> parseFun) throws Exception {
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
}
