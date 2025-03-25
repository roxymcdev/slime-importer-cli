package net.roxymc.slime.importer.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.parameters.options.*
import com.github.ajalt.clikt.parameters.types.enum
import com.github.ajalt.clikt.parameters.types.file
import net.roxymc.slime.importer.cli.world.impl.SlimeHeightmaps
import net.roxymc.slime.importer.cli.world.impl.SlimeWorld
import net.roxymc.slime.importer.cli.world.impl.biome.SlimeBiomes
import net.roxymc.slime.importer.cli.world.impl.block.entity.SlimeBlockEntity
import net.roxymc.slime.importer.cli.world.impl.block.state.SlimeBlockStates
import net.roxymc.slime.importer.cli.world.impl.chunk.SlimeChunk
import net.roxymc.slime.importer.cli.world.impl.chunk.SlimeSection
import net.roxymc.slime.importer.cli.world.impl.entity.SlimeEntity
import net.roxymc.slime.loader.SlimeLoader

class Main : CliktCommand() {
    private val importer by option("-i", "--importer")
        .enum<Importer>()
        .help("The importer type")
        .required()
    private val source by option("-s", "--source")
        .file(mustExist = true, canBeDir = true, mustBeReadable = true)
        .convert { it.absoluteFile }
        .help("The input file/dir path")
        .required()
    private val output by option("-o", "--output")
        .file(canBeFile = false, canBeDir = false)
        .convert { it.absoluteFile }
        .help("The output file path")
        .required()
    private val worldTags by option()
        .split(",")
        .help("World tags to preserve (supported only by Anvil)")
        .default(emptyList())
    private val chunkTags by option()
        .split(",")
        .help("Chunk tags to preserve (supported only by Anvil)")
        .default(emptyList())
    private val optimizeChunks by option()
        .help("Enables chunks optimization (skips empty chunks)")
        .flag()

    private val slimeLoader = SlimeLoader.builder()
        .deserializers { builder ->
            builder
                .biomes(::SlimeBiomes)
                .blockEntity(::SlimeBlockEntity)
                .blockStates(::SlimeBlockStates)
                .chunk(::SlimeChunk)
                .section(::SlimeSection)
                .entity(::SlimeEntity)
                .heightmaps(::SlimeHeightmaps)
                .world(::SlimeWorld)
        }
        .build()

    override fun run() {
        val importStart = System.currentTimeMillis()

        val slimeImporter = importer.build(slimeLoader, worldTags.toTypedArray(), chunkTags.toTypedArray(), optimizeChunks)
        val result = try {
            slimeImporter.importWorld(source)
        } catch (e: Exception) {
            System.err.println("Failed to read world from $source")
            throw e
        }

        val saveStart = System.currentTimeMillis()

        output.apply { parentFile.mkdirs() }.writeBytes(slimeLoader.save(result.world))
        println("Successfully imported world from $source in ${saveStart - importStart}ms and saved it to $output in ${System.currentTimeMillis() - saveStart}ms")
    }
}

fun main(args: Array<String>) = Main().main(args)
