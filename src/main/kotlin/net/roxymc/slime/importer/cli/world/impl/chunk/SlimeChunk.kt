package net.roxymc.slime.importer.cli.world.impl.chunk

import net.kyori.adventure.nbt.CompoundBinaryTag
import net.roxymc.slime.world.Heightmaps
import net.roxymc.slime.world.block.entity.BlockEntity
import net.roxymc.slime.world.chunk.Chunk
import net.roxymc.slime.world.chunk.Section
import net.roxymc.slime.world.entity.Entity

class SlimeChunk(
    private val x: Int,
    private val z: Int,
    private val sections: Array<Section>,
    private val heightmaps: Heightmaps,
    private val blockEntities: Array<BlockEntity>,
    private val entities: Array<Entity>,
    private val tag: CompoundBinaryTag
) : Chunk {
    override fun x(): Int = x

    override fun z(): Int = z

    override fun sections(): Array<Section> = sections

    override fun heightmaps(): Heightmaps = heightmaps

    override fun blockEntities(): Array<BlockEntity> = blockEntities

    override fun entities(): Array<Entity> = entities

    override fun tag(): CompoundBinaryTag = tag
}