package net.roxymc.slime.importer.cli.impl.world.biome

import net.kyori.adventure.nbt.CompoundBinaryTag
import net.roxymc.slime.world.biome.Biomes

class SlimeBiomes(
    private val tag: CompoundBinaryTag
) : Biomes {
    override fun tag(): CompoundBinaryTag = tag
}