package net.roxymc.slime.importer.cli.impl.world.entity

import net.kyori.adventure.nbt.CompoundBinaryTag
import net.roxymc.slime.world.entity.Entity

class SlimeEntity(
    private val tag: CompoundBinaryTag
) : Entity {
    override fun tag(): CompoundBinaryTag = tag
}