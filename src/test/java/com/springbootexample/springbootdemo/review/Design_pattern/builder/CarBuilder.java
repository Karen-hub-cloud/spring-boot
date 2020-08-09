package com.springbootexample.springbootdemo.review.Design_pattern.builder;

public class CarBuilder implements Builder{
    private Type type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setType(Type type) {

    }

    @Override
    public void setSeats(int seats) {

    }

    @Override
    public void setEngine(Engine engine) {

    }

    @Override
    public void setTransmission(Transmission transmission) {

    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {

    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {

    }

    public Car getResult() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
