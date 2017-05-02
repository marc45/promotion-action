package com.jd.jr.pattern.created.factory;

/**
 * Created by shifeifei on 2017/3/28.
 * 工厂类
 */
public class VehicleFactory {

    public Vehicle getVehicle(String vehicleType) {

        if (null == vehicleType) {
            return null;
        }

        if (VehicleEnum.CAR.getCode().equals(vehicleType)) {
            return new Car();
        } else if (VehicleEnum.BUS.getCode().equals(vehicleType)) {
            return new Bus();
        }
        return null;
    }
}
