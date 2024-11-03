package net.roxymc.slime.importer.cli

import net.roxymc.slime.importer.SlimeImporter
import net.roxymc.slime.importer.anvil.SlimeAnvilImporter
import net.roxymc.slime.loader.SlimeLoader

enum class Importer(private val importer: (SlimeLoader, Array<String>, Array<String>) -> SlimeImporter) {
    ANVIL({ slimeLoader, worldTags, chunkTags ->
        SlimeAnvilImporter.builder(slimeLoader)
            .preserveWorldTags(*worldTags)
            .preserveChunkTags(*chunkTags)
            .build()
    });

    fun build(slimeLoader: SlimeLoader, worldTags: Array<String>, chunkTags: Array<String>): SlimeImporter =
        importer(slimeLoader, worldTags, chunkTags)
}