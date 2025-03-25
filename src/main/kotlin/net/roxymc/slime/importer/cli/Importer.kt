package net.roxymc.slime.importer.cli

import net.roxymc.slime.importer.SlimeImporter
import net.roxymc.slime.importer.anvil.SlimeAnvilImporter
import net.roxymc.slime.loader.SlimeLoader

enum class Importer(private val importer: (SlimeLoader, Array<String>, Array<String>, Boolean) -> SlimeImporter) {
    ANVIL({ slimeLoader, worldTags, chunkTags, optimizeChunks ->
        SlimeAnvilImporter.builder(slimeLoader)
            .preserveWorldTags(*worldTags)
            .preserveChunkTags(*chunkTags)
            .optimizeChunks(optimizeChunks)
            .build()
    });

    fun build(slimeLoader: SlimeLoader, worldTags: Array<String>, chunkTags: Array<String>, optimizeChunks: Boolean): SlimeImporter =
        importer(slimeLoader, worldTags, chunkTags, optimizeChunks)
}