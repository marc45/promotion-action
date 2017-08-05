package com.jd.jr.pattern.created.factory;

/**
 * Created by shifeifei on 2017/3/28.
 */
public class Test {

    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle car = factory.getVehicle("car");
        car.createdVehicle();

        Vehicle bus = factory.getVehicle("bus");
        bus.createdVehicle();

    }
}
