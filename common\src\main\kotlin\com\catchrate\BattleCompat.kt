package com.catchrate

import com.cobblemon.mod.common.api.battles.model.actor.ActorType
import com.cobblemon.mod.common.client.battle.ClientBattle

/** Compatibility helpers for the 1.20.1 Cobblemon battle model. */
object BattleCompat {
    fun isPlayerVsWild(battle: ClientBattle?): Boolean =
        battle?.sides?.any { side -> side.actors.any { it.type == ActorType.WILD } } == true
}
