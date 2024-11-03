package net.roxymc.slime.importer.cli.impl.world

import net.kyori.adventure.nbt.CompoundBinaryTag
import net.roxymc.slime.world.Heightmaps

class SlimeHeightmaps(
    private val tag: CompoundBinaryTag
) : Heightmaps {
    override fun tag(): CompoundBinaryTag = tag
}