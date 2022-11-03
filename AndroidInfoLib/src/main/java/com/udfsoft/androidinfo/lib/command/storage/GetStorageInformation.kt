/*
 * Copyright 2022 Javavirys
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.udfsoft.androidinfo.lib.command.storage

import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.command.entity.storage.MutableStorageInformation
import com.udfsoft.androidinfo.lib.entity.StorageInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi

class GetStorageInformation(
    private val api: AndroidInfoApi
) : CommandInterface<Unit, StorageInformation> {

    override fun invoke(param: Unit): StorageInformation {
        val mutableEntity = MutableStorageInformation()

        GetLocalStorageInformation().invoke(mutableEntity)
        GetCloudStorageInformation(api).invoke(mutableEntity)

        return mutableEntity.build()
    }
}