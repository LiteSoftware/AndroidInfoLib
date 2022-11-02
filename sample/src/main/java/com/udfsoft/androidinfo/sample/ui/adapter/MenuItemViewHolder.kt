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
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.udfsoft.androidinfo.sample.R
import com.udfsoft.androidinfo.sample.core.entity.MenuItem

class MenuItemViewHolder(
    view: View,
    private val onItemClick: (MenuItem) -> Unit
) : RecyclerView.ViewHolder(view) {

    private val nameTextView: TextView = ViewCompat.requireViewById(itemView, R.id.nameTextView)

    private val logoImageView: ImageView =
        ViewCompat.requireViewById(itemView, R.id.logoImageView)

    fun onBind(item: MenuItem) {
        itemView.setOnClickListener {
            onItemClick(item)
        }
        nameTextView.text = item.name
        logoImageView.setImageResource(item.logoId)
    }
}