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

package com.udfsoft.androidinfo.lib.command.audio

import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.command.entity.audio.MutableAudioInformation
import com.udfsoft.androidinfo.lib.entity.AudioInformation
import com.udfsoft.androidinfo.lib.network.AndroidInfoApi

class GetAudioInformationCommand(
    private val api: AndroidInfoApi
) : CommandInterface<Unit, AudioInformation> {

    override fun invoke(param: Unit) = MutableAudioInformation().also {
        GetCloudAudioInformationCommand(api).invoke(it)
    }.build()
}