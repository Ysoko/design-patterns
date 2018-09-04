package org.dfreer.designpatterns.observer.weather

import java.util.Observable
import java.util.Observer

class WeatherData : Observable() {
    private val observers = mutableSetOf<Observer>()
    var temperature: Float = 0F
        private set
    var humidity: Float = 0F
        private set
    var pressure: Float = 0F
        private set

    private fun measurementsChanged() {
        setChanged()
        notifyObservers()
    }

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun deleteObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers(argument: Any?) {
        if (hasChanged()) {
            observers.forEach { it.update(this, argument) }
            clearChanged()
        }
    }

    override fun notifyObservers() = notifyObservers(null)

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }
}
