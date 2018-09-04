package org.dfreer.designpatterns.observer.weather.displays

import org.dfreer.designpatterns.observer.weather.Display
import org.dfreer.designpatterns.observer.weather.WeatherData
import java.util.Observable

class CurrentConditionsDisplay(private val weatherData: Observable) : Display {
    init {
        weatherData.addObserver(this)
    }

    private var temperature: Float = 0F
    private var humidity: Float = 0F

    private fun update(temperature: Float, humidity: Float) {
        this.temperature = temperature
        this.humidity = humidity
        display()
    }

    override fun update(o: Observable?, arg: Any?) {
        if (o is WeatherData) update(o.temperature, o.humidity)
    }

    override fun display() = println("Current conditions: ${temperature}F degrees and $humidity% humidity")

    override fun close() {
        weatherData.deleteObserver(this)
    }
}
