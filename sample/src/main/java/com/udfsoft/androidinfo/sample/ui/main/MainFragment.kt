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

package com.udfsoft.androidinfo.sample.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.udfsoft.androidinfo.sample.R
import com.udfsoft.androidinfo.sample.core.entity.MenuItem
import com.udfsoft.androidinfo.sample.databinding.FragmentMainBinding
import com.udfsoft.androidinfo.sample.ui.adapter.MenuItemAdapter
import com.udfsoft.androidinfo.sample.ui.details.DetailsFragment

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMainBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLiveData()
        viewModel.loadMenu()
    }

    private fun initLiveData() {
        viewModel.getMenuLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
            binding.menuRecyclerView.adapter = MenuItemAdapter(::onMenuItemClick).apply {
                setItems(it)
            }
        }
    }

    private fun onMenuItemClick(item: MenuItem) {
        requireActivity().supportFragmentManager
            .commit {
                replace(R.id.container, DetailsFragment.newInstance(item.id))
                addToBackStack(null)
            }
    }

    companion object {
        private val TAG = MainFragment::class.simpleName
        fun newInstance() = MainFragment()
    }
}