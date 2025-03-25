package net.roxymc.slime.importer.cli.world.impl

import net.kyori.adventure.nbt.CompoundBinaryTag
import net.roxymc.slime.world.World
import net.roxymc.slime.world.chunk.Chunk

class SlimeWorld(
    private val version: Int,
    private val chunks: Array<Chunk>,
    private val tag: CompoundBinaryTag
) : World {
    override fun version(): Int = version

    override fun chunks(): Array<Chunk> = chunks

    override fun tag(): CompoundBinaryTag = tag
}
