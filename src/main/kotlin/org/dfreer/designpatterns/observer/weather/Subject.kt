package org.dfreer.designpatterns.observer.weather

interface Subject {
    fun addObserver(observer: Observer)
    fun deleteObserver(observer: Observer)
    fun notifyObservers()
}
