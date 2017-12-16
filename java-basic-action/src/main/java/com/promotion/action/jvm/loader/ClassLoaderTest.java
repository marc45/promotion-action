package com.promotion.action.jvm.loader;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {


    public static void main(String[] args) {

        //自定义了一个简单的类加载器
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (null == is) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read();
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = null;
        try {
            obj = myLoader.loadClass("com.promotion.action.jvm.loader.ClassLoaderTest").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.promotion.action.jvm.loader.ClassLoaderTest);

    }

}
