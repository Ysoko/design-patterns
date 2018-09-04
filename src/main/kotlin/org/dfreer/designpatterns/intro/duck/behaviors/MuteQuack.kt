package org.dfreer.designpatterns.intro.duck.behaviors

class MuteQuack : QuackBehavior {
    override fun quack() = println("<< Silence >>")
}
