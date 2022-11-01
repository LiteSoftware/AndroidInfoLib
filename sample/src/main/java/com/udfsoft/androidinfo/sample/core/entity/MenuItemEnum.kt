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

package com.udfsoft.androidinfo.sample.core.entity

import androidx.annotation.DrawableRes
import com.udfsoft.androidinfo.sample.R

enum class MenuItemEnum(
    val title: String,
    @DrawableRes val logoId: Int
) {

    General("General", R.drawable.ic_general),
    Design("Design", R.drawable.ic_launcher_foreground),
    SIMCard("SIM card", R.drawable.ic_launcher_foreground),
    MobileNetworkTechnologies("Mobile network technologies", R.drawable.ic_launcher_foreground),
    OperatingSystem("Operating system", R.drawable.ic_launcher_foreground),
    CPU("CPU", R.drawable.ic_launcher_foreground),
    GPU("GPU", R.drawable.ic_launcher_foreground),
    RAM("RAM", R.drawable.ic_launcher_foreground),
    Storage("Storage", R.drawable.ic_launcher_foreground),
    Display("Display", R.drawable.ic_launcher_foreground),
    Sensors("Sensors", R.drawable.ic_launcher_foreground),
    RearCamera("Rear camera", R.drawable.ic_launcher_foreground),
    FrontCamera("Front camera", R.drawable.ic_launcher_foreground),
    Audio("Audio", R.drawable.ic_launcher_foreground),
    WirelessTechnology("Wireless technology", R.drawable.ic_launcher_foreground),
    USB("USB", R.drawable.ic_launcher_foreground),
    Browser("Browser", R.drawable.ic_launcher_foreground);
}
