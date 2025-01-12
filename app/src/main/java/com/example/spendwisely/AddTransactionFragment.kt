package com.example.spendwisely

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.spendwisely.databinding.FragmentAddTransactionBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddTransactionFragment : BottomSheetDialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var binding: FragmentAddTransactionBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTransactionBinding.inflate(inflater);

        binding?.Incomebtn?.setOnClickListener {
            binding?.Incomebtn?.background = context?.getDrawable(R.drawable.income_selector);
            binding?.expensebtn?.background = context?.getDrawable(R.drawable.default_select);
            binding?.expensebtn?.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.textcolor
                )
            )
            binding?.Incomebtn?.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.Green
                )
            )


        }

        binding?.expensebtn?.setOnClickListener {
            binding?.Incomebtn?.background = context?.getDrawable(R.drawable.default_select);
            binding?.expensebtn?.background = context?.getDrawable(R.drawable.expene_selector);
            binding?.expensebtn?.setTextColor(ContextCompat.getColor(requireContext(), R.color.Red))
            binding?.Incomebtn?.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.textcolor
                )
            )
        }

        binding?.date?.setOnClickListener {
            val datePickerDialog = DatePickerDialog(requireContext())
            datePickerDialog.show()
        }




        return binding!!.root
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}