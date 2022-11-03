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

package com.udfsoft.androidinfo.sample.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.udfsoft.androidinfo.sample.R

class MapViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val nameTextView: TextView = ViewCompat.requireViewById(itemView, R.id.nameTextView)

    private val valueTextView: TextView = ViewCompat.requireViewById(itemView, R.id.valueTextView)

    fun onBind(item: Pair<String, Any?>) {
        val name = item.first.replaceFirstChar { it.uppercase() }
        nameTextView.text = name
        valueTextView.text = item.second.toString()
    }
}