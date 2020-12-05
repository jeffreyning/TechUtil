package com.github.jeffreyning.techutil;

import java.io.Serializable;

@FunctionalInterface
public interface ParseFun<T, R> extends java.util.function.Function<T, R>, Serializable {

}
