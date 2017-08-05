package com.promotion.action.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shifeifei on 2017/5/8.
 */
public class HeapOOM {


    static class OOMObject {
    }

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }

    }

}
