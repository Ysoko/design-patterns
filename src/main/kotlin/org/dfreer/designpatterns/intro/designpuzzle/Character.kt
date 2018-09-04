package org.dfreer.designpatterns.intro.designpuzzle

import org.dfreer.designpatterns.intro.designpuzzle.weapons.WeaponBehavior

abstract class Character {
    abstract var weapon: WeaponBehavior
    fun fight() = weapon.useWeapon()
}
