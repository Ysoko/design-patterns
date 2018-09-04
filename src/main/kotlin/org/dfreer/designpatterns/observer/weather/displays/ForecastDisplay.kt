package org.dfreer.designpatterns.observer.weather.displays

import org.dfreer.designpatterns.observer.weather.Display
import org.dfreer.designpatterns.observer.weather.WeatherData
import java.util.Observable

class ForecastDisplay(private val weatherData: Observable) : Display {
    init {
        weatherData.addObserver(this)
    }

    private var currentPressure: Float = 29.9F
    private var lastPressure: Float = 0F

    private fun update(pressure: Float) {
        lastPressure = currentPressure
        currentPressure = pressure
        display()
    }

    override fun update(o: Observable?, arg: Any?) {
        if (o is WeatherData) update(o.pressure)
    }

    override fun display() {
        print("Forecast: ")
        when {
            currentPressure > lastPressure -> println("Improving weather on the way!")
            currentPressure == lastPressure -> println("More of the same")
            currentPressure < lastPressure -> println("Watch out for cooler, rainy weather")
        }
    }

    override fun close() {
        weatherData.deleteObserver(this)
    }
}
