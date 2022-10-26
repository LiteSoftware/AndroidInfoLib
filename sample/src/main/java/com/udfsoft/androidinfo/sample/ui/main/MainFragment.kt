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

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.udfsoft.androidinfo.sample.R

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel by viewModels<MainViewModel>()

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            val grantedPermissions = it.values.filter { isGranted -> isGranted }.size
            val isGranted = grantedPermissions == 3
            if (isGranted) {
                loadInformation()
            } else {
                Toast.makeText(requireContext(), "Permissions denied!", Toast.LENGTH_SHORT).show()
            }
        }

    private fun loadInformation() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_SMS
            ) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_PHONE_NUMBERS
            ) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_PHONE_STATE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(requireContext(), "Permissions denied!", Toast.LENGTH_SHORT).show()
            launchRequestPermissions()
            return
        }
        viewModel.loadInformation(requireActivity())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLiveData()
        requestPermissions()
    }

    private fun requestPermissions() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(), Manifest.permission.READ_PHONE_STATE
            ) && ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(), Manifest.permission.READ_SMS
            ) && ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(), "android.permission.READ_PHONE_NUMBERS"
            )
        ) {
            launchRequestPermissions()
        } else {
            launchRequestPermissions()
        }
    }

    private fun launchRequestPermissions() {
        requestPermissionLauncher.launch(
            arrayOf(
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.READ_SMS,
                "android.permission.READ_PHONE_NUMBERS"
            )
        )
    }


    private fun initLiveData() {
        viewModel.getGeneralInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }

        viewModel.getRAMInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }

        viewModel.getOSInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }

        viewModel.getCPUInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }

        viewModel.getSIMCardInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }

        viewModel.getDisplayInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }

        viewModel.getNetworkTechnologiesInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }

        viewModel.getDesignInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }

        viewModel.getStorageInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }

        viewModel.getGPUInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }

        viewModel.getSensorsInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }

        viewModel.getRearCameraInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, it.toString())
        }
    }

    companion object {
        private val TAG = MainFragment::class.simpleName
        fun newInstance() = MainFragment()
    }
}