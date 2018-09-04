package org.dfreer.designpatterns.observer.weather

import java.util.Observer

interface Display : Observer, AutoCloseable {
    fun display()
}
