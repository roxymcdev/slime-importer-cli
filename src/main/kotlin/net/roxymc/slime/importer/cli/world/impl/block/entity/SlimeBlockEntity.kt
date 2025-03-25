package net.roxymc.slime.importer.cli.world.impl.block.entity

import net.kyori.adventure.nbt.CompoundBinaryTag
import net.roxymc.slime.world.block.entity.BlockEntity

class SlimeBlockEntity(
    private val tag: CompoundBinaryTag
) : BlockEntity {
    override fun tag(): CompoundBinaryTag = tag
}