package com.example.practice_16

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.practice_16.databinding.FragmentUserBinding
import kotlin.random.Random

class UserFragment : Fragment() {
    lateinit var binding: FragmentUserBinding
    private val dataModel: DataModel by activityViewModels()
    var trueCounterU = 0
    var falseCounterU = 0
    var allCounterU = 0
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentUserBinding.inflate(inflater)

        binding.txtNumUserFirst2.text = (1..6).random().toString()
        binding.txtNumUserSecond2.text = (1..6).random().toString()
        binding.txtNumUserThird2.text = (1..6).random().toString()
        binding.txtNumUserSum2.text = (binding.txtNumUserFirst2.text.toString().toInt() +
                binding.txtNumUserSecond2.text.toString().toInt() +
                binding.txtNumUserThird2.text.toString().toInt()).toString()
        ++allCounterU

        when ((0..1).random()){
            0 -> {binding.rbtnEvenUser2.isChecked = true
                binding.rbtnEvenUser2.isEnabled = false
                binding.rbtnNotEvenUser2.isEnabled = false
                binding.linearLayoutUser.isVisible = true
                binding.imgUser.isVisible = true
                if (binding.txtNumUserSum2.text.toString().toInt() % 2 == 0 && binding.rbtnEvenUser2.isChecked)
                {
                    binding.imgUser.setImageResource(R.drawable.img_true)
                    ++trueCounterU
                    dataModel.messageFromUserFragmentTrue.value = trueCounterU.toString()
                }
                else
                {
                    binding.imgUser.setImageResource(R.drawable.img_false)
                    ++falseCounterU
                    dataModel.messageFromUserFragmentTrue.value = trueCounterU.toString()
                }
            }
            1 -> {
                binding.rbtnNotEvenUser2.isChecked = true
                binding.rbtnEvenUser2.isEnabled = false
                binding.rbtnNotEvenUser2.isEnabled = false
                binding.linearLayoutUser.isVisible = true
                binding.imgUser.isVisible = true
                if (binding.txtNumUserSum2.text.toString().toInt() % 2 == 1 && binding.rbtnNotEvenUser2.isChecked)
                {
                    binding.imgUser.setImageResource(R.drawable.img_true)
                    ++trueCounterU
                    dataModel.messageFromUserFragmentTrue.value = trueCounterU.toString()
                }
                else
                {
                    binding.imgUser.setImageResource(R.drawable.img_false)
                    ++falseCounterU
                    dataModel.messageFromUserFragmentTrue.value = trueCounterU.toString()
                }
            }
        }
        return binding.root
    }


    fun resetUserFields() {
        binding.rbtnEvenUser2.isChecked = false
        binding.rbtnNotEvenUser2.isChecked = false

        binding.txtNumUserFirst2.text = ""
        binding.txtNumUserSecond2.text = ""
        binding.txtNumUserThird2.text = ""
        binding.txtNumUserSum2.text = ""

        binding.txtNumUserFirst2.text = (1..6).random().toString()
        binding.txtNumUserSecond2.text = (1..6).random().toString()
        binding.txtNumUserThird2.text = (1..6).random().toString()
        binding.txtNumUserSum2.text = (binding.txtNumUserFirst2.text.toString().toInt() +
                binding.txtNumUserSecond2.text.toString().toInt() +
                binding.txtNumUserThird2.text.toString().toInt()).toString()
        ++allCounterU

        when ((0..1).random()){
            0 -> {binding.rbtnEvenUser2.isChecked = true
                binding.rbtnEvenUser2.isEnabled = false
                binding.rbtnNotEvenUser2.isEnabled = false
                binding.linearLayoutUser.isVisible = true
                binding.imgUser.isVisible = true
                if (binding.txtNumUserSum2.text.toString().toInt() % 2 == 0 && binding.rbtnEvenUser2.isChecked)
                {
                    binding.imgUser.setImageResource(R.drawable.img_true)
                    ++trueCounterU
                    dataModel.messageFromUserFragmentTrue.value = trueCounterU.toString()
                }
                else
                {
                    binding.imgUser.setImageResource(R.drawable.img_false)
                    ++falseCounterU
                    dataModel.messageFromUserFragmentTrue.value = trueCounterU.toString()
                }
            }
            1 -> {
                binding.rbtnNotEvenUser2.isChecked = true
                binding.rbtnEvenUser2.isEnabled = false
                binding.rbtnNotEvenUser2.isEnabled = false
                binding.linearLayoutUser.isVisible = true
                binding.imgUser.isVisible = true
                if (binding.txtNumUserSum2.text.toString().toInt() % 2 == 1 && binding.rbtnNotEvenUser2.isChecked)
                {
                    binding.imgUser.setImageResource(R.drawable.img_true)
                    ++trueCounterU
                    dataModel.messageFromUserFragmentTrue.value = trueCounterU.toString()
                }
                else
                {
                    binding.imgUser.setImageResource(R.drawable.img_false)
                    ++falseCounterU
                    dataModel.messageFromUserFragmentTrue.value = trueCounterU.toString()
                }
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = UserFragment()
    }


}