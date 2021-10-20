/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.configurationcache

import org.gradle.cache.internal.streams.ValueStore
import java.io.File
import java.io.OutputStream


internal
interface ConfigurationCacheStateStore {
    fun assignSpoolFile(stateType: StateType): File

    fun <T> useForStateLoad(stateType: StateType, action: (ConfigurationCacheStateFile) -> T): T

    fun useForStore(stateType: StateType, action: (ConfigurationCacheRepository.Layout) -> Unit)

    fun <T> createValueStore(baseName: String, factory: (OutputStream) -> ValueStore.Writer<T>): ValueStore<T>
}
