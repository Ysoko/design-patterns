package org.dfreer.designpatterns.observer.weather

import org.dfreer.designpatterns.observer.weather.displays.CurrentConditionsDisplay
import org.dfreer.designpatterns.observer.weather.displays.ForecastDisplay
import org.dfreer.designpatterns.observer.weather.displays.HeatIndexDisplay
import org.dfreer.designpatterns.observer.weather.displays.StatisticsDisplay
import org.junit.Test

class WeatherStationTest {
    private val weatherData: WeatherData = WeatherData()

    private fun changeWeather() {
        weatherData.setMeasurements(80F, 65F, 30.4F)
        weatherData.setMeasurements(82F, 70F, 29.2F)
        weatherData.setMeasurements(78F, 90F, 29.2F)
    }

    @Test
    fun `Current weather conditions display test`() {
        CurrentConditionsDisplay(weatherData).use {
            changeWeather()
        }
    }

    @Test
    fun `Weather statistics display test`() {
        StatisticsDisplay(weatherData).use {
            changeWeather()
        }
    }

    @Test
    fun `Weather forecast display test`() {
        ForecastDisplay(weatherData).use {
            changeWeather()
        }
    }

    @Test
    fun `Weather heat index display test`() {
        HeatIndexDisplay(weatherData).use {
            changeWeather()
        }
    }

    @Test
    fun `Weather show all displays test`() {
        val observers = mutableSetOf<Display>()
        try {
            observers.add(CurrentConditionsDisplay(weatherData))
            observers.add(StatisticsDisplay(weatherData))
            observers.add(ForecastDisplay(weatherData))
            observers.add(HeatIndexDisplay(weatherData))
            changeWeather()
        } finally {
            observers.forEach { display ->
                display.close()
            }
        }
    }
}
