package org.dfreer.designpatterns.observer.weather

interface Observer {
    fun update(temperature: Float, humidity: Float, pressure: Float)
}
