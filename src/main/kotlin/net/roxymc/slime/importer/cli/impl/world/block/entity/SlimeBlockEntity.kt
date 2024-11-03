package net.roxymc.slime.importer.cli.impl.world.block.entity

import net.kyori.adventure.nbt.CompoundBinaryTag
import net.roxymc.slime.world.block.entity.BlockEntity

class SlimeBlockEntity(
    private val tag: CompoundBinaryTag
) : BlockEntity {
    override fun tag(): CompoundBinaryTag = tag
}