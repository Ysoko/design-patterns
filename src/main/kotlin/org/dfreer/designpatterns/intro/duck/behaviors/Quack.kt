package org.dfreer.designpatterns.intro.duck.behaviors

class Quack : QuackBehavior {
    override fun quack() = println("Quack")
}
