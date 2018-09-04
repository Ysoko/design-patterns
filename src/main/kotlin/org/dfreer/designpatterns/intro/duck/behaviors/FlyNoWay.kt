package org.dfreer.designpatterns.intro.duck.behaviors

class FlyNoWay : FlyBehavior {
    override fun fly() = println("I can't fly")
}
