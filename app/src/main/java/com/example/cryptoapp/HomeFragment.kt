package com.example.cryptoapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.cryptoapp.adapter.TopMarketAdapter
import com.example.cryptoapp.api.apiInterface
import com.example.cryptoapp.api.apiUtilities
import com.example.cryptoapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {

   private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        getTopCurrencyList()
        return binding.root
    }

    private fun getTopCurrencyList() {
       lifecycleScope.launch(Dispatchers.IO) {
           val res = apiUtilities.getInstance().create(apiInterface::class.java).getMarketData()

            withContext(Dispatchers.Main){
                binding.topCurrencyRecyclerView.adapter = TopMarketAdapter(requireContext(),res.body()!!.data.cryptoCurrencyList)
            }


               Log.d("DINESH", "getTopCurrencyList:${res.body()!!.data.cryptoCurrencyList}")



       }}

    }


