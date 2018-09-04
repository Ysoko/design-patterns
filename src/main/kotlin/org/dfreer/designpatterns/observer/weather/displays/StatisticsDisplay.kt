package org.dfreer.designpatterns.observer.weather.displays

import org.dfreer.designpatterns.observer.weather.Display
import org.dfreer.designpatterns.observer.weather.WeatherData
import java.util.Observable

class StatisticsDisplay(private val weatherData: Observable) : Display {
    init {
        weatherData.addObserver(this)
    }

    private var maxTemp: Float = 0F
    private var minTemp: Float = 200F
    private var sumTemp: Float = 0F
    private var numReadings: Int = 0

    private fun update(temperature: Float) {
        numReadings++

        sumTemp += temperature
        if (temperature > maxTemp) maxTemp = temperature
        if (temperature < minTemp) minTemp = temperature

        display()
    }

    override fun update(o: Observable?, arg: Any?) {
        if (o is WeatherData) update(o.temperature)
    }

    override fun display() {
        val avgTemp: Float = sumTemp / numReadings
        println("Avg/Max/Min temperature = $avgTemp/$maxTemp/$minTemp")
    }

    override fun close() {
        weatherData.deleteObserver(this)
    }
}
