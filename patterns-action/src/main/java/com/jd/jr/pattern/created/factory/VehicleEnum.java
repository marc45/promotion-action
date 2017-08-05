package com.jd.jr.pattern.created.factory;

/**
 * Created by shifeifei on 2017/3/28.
 */
public enum VehicleEnum {

    CAR("car", "小轿车"),
    BUS("bus", "公共汽车");

    private String code;
    private String info;

    VehicleEnum(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
