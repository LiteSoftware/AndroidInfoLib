package com.udfsoft.androidinfo.sample.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.udfsoft.androidinfo.sample.R

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLiveData()
        viewModel.loadInformation()
    }

    private fun initLiveData() {
        viewModel.getGeneralInformationLiveData().observe(viewLifecycleOwner) {
            Log.d(TAG, "GeneralInformation: $it")
        }
    }

    companion object {
        private val TAG = MainFragment::class.simpleName
        fun newInstance() = MainFragment()
    }
}