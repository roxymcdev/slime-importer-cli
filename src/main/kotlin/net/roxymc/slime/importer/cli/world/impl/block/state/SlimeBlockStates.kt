package net.roxymc.slime.importer.cli.world.impl.block.state

import net.kyori.adventure.nbt.CompoundBinaryTag
import net.roxymc.slime.world.block.state.BlockStates

class SlimeBlockStates(
    private val tag: CompoundBinaryTag
) : BlockStates {
    override fun tag(): CompoundBinaryTag = tag
}