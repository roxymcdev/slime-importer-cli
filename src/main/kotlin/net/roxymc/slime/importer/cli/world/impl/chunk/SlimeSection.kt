package net.roxymc.slime.importer.cli.world.impl.chunk

import net.roxymc.slime.world.biome.Biomes
import net.roxymc.slime.world.block.state.BlockStates
import net.roxymc.slime.world.chunk.Section

class SlimeSection(
    private val blockLight: ByteArray?,
    private val skyLight: ByteArray?,
    private val blockStates: BlockStates,
    private val biomes: Biomes
) : Section {
    override fun blockLight(): ByteArray? = blockLight

    override fun skyLight(): ByteArray? = skyLight

    override fun blockStates(): BlockStates = blockStates

    override fun biomes(): Biomes = biomes
}