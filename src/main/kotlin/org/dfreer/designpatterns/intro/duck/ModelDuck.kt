package org.dfreer.designpatterns.intro.duck

import org.dfreer.designpatterns.intro.duck.behaviors.FlyBehavior
import org.dfreer.designpatterns.intro.duck.behaviors.FlyNoWay
import org.dfreer.designpatterns.intro.duck.behaviors.Quack
import org.dfreer.designpatterns.intro.duck.behaviors.QuackBehavior

class ModelDuck(
    override var flyBehavior: FlyBehavior = FlyNoWay(),
    override var quackBehavior: QuackBehavior = Quack()
) : Duck() {
    override fun display() = println("I'm a model duck")
}
