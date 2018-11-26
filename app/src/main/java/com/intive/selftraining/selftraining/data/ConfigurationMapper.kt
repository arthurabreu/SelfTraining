package com.intive.selftraining.selftraining.data

import com.intive.selftraining.selftraining.listmovies.model.Configuration
import com.intive.selftraining.selftraining.network.models.ConfigurationEntity

class ConfigurationMapper: Mapper<ConfigurationEntity, Configuration>{

    /**
     * Map a [ConfigurationEntity] instance to a [Configuration] instance
     */
    override fun mapFromEntity(type: ConfigurationEntity): Configuration {
        return Configuration(
            type.change_keys,
            type.images
        )
    }

    /**
     * Map a [Configuration] instance to a [ConfigurationEntity] instance
     */
    override fun mapToEntity(type: Configuration): ConfigurationEntity {
        return ConfigurationEntity(
            type.changeKeys,
            type.images
        )
    }
}