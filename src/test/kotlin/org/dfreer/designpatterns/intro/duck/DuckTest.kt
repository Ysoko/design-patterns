package org.dfreer.designpatterns.intro.duck

import org.dfreer.designpatterns.intro.duck.behaviors.FlyRocketPowered
import org.junit.Test

class DuckTest {
    @Test
    fun `Mallard duck test`() {
        val mallard: Duck =
            MallardDuck()
        mallard.performQuack()
        mallard.performFly()
    }

    @Test
    fun `Model duck test`() {
        val model: Duck =
            ModelDuck()
        model.performFly()
        model.flyBehavior = FlyRocketPowered()
        model.performFly()
    }
}
