package com.promotion.action.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shifeifei on 2017/5/1.
 */
public class TestUseCase {

    public static void traceUseCases(List<Integer> useCases, Class<?> cla) {

        for (Method m : cla.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (null != uc) {
                System.out.println("found use case :" + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }

        for (int i : useCases) {
            System.out.println("warning : Missing use case - " + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        traceUseCases(useCases, PasswordUtil.class);
    }

}
