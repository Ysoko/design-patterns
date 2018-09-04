package org.dfreer.designpatterns.intro.duck

import org.dfreer.designpatterns.intro.duck.behaviors.FlyBehavior
import org.dfreer.designpatterns.intro.duck.behaviors.FlyWithWings
import org.dfreer.designpatterns.intro.duck.behaviors.Quack
import org.dfreer.designpatterns.intro.duck.behaviors.QuackBehavior

class MallardDuck(
    override var flyBehavior: FlyBehavior = FlyWithWings(),
    override var quackBehavior: QuackBehavior = Quack()
) : Duck() {
    override fun display() = println("I'm a real Mallard duck")
}
