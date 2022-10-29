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

package com.udfsoft.androidinfo.lib.command.entity.battery

import com.udfsoft.androidinfo.lib.command.entity.MutableEntity
import com.udfsoft.androidinfo.lib.entity.BatteryInformation

data class MutableBatteryInformation(
    var capacity: String? = null,
    var type: String? = null,
    var chargerOutputPower: String? = null,
    var features: String? = null,
) : MutableEntity<BatteryInformation> {

    override fun build() = BatteryInformation(capacity, type, chargerOutputPower, features)
}