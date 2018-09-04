package org.dfreer.designpatterns.intro.duck.behaviors

class FlyRocketPowered : FlyBehavior {
    override fun fly() = println("I'm flying with a rocket!")
}
