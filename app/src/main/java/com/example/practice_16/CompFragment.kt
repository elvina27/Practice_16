package com.example.practice_16

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.practice_16.databinding.FragmentCompBinding

class CompFragment : Fragment() {
    lateinit var binding: FragmentCompBinding
    private val dataModel: DataModel by activityViewModels()
    var trueCounter = 0
    var falseCounter = 0
    var allCounter = 0
    val rbClick = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompBinding.inflate(inflater)

        rand()

        dataModel.messageForCompFragment.observe(activity as LifecycleOwner) {
            val btnClick = it.toString().toBoolean()
            if (btnClick) {
                binding.linearLayoutComp.isVisible = true
                binding.imgComp.isVisible = true
            }
        }

        binding.rbtnEvenComp2.setOnClickListener {//устанавливает слушатель клика на RadioButton для четных чисел.
            dataModel.messageFromCompFragment.value = rbClick.toString() //сохраняет значение клика в dataModel.
            binding.rbtnEvenComp2.isEnabled = false // отключает RadioButton для четных чисел после клика.
            binding.rbtnNotEvenComp2.isEnabled = false //отключает RadioButton для нечетных чисел после клика.
            ++allCounter //увеличивает счетчик общего числа попыток.
            //проверяет, является ли сумма чисел четной и RadioButton для четных чисел выбран.
            if (binding.txtNumCompSum2.text.toString().toInt() % 2 == 0 && binding.rbtnEvenComp2.isChecked)
            {
                binding.imgComp.setImageResource(R.drawable.img_true)
                ++trueCounter //увеличивает счетчик правильных ответов.
                dataModel.messageFromCompFragmentTrue.value = trueCounter.toString() // сохраняет значение счетчика правильных ответов в dataModel.
            } else {
                binding.imgComp.setImageResource(R.drawable.img_false) //станавливает изображение для неправильного ответа.
                ++falseCounter //увеличивает счетчик неправильных ответов.
                dataModel.messageFromCompFragmentTrue.value = trueCounter.toString() //сохраняет значение счетчика правильных ответов в dataModel.
            }
        }

        binding.rbtnNotEvenComp2.setOnClickListener {//устанавливает слушатель клика на RadioButton для нечетных чисел.
            dataModel.messageFromCompFragment.value = rbClick.toString()
            binding.rbtnEvenComp2.isEnabled = false
            binding.rbtnNotEvenComp2.isEnabled = false
            ++allCounter //увеличивает счетчик общего числа попыток.
            if (binding.txtNumCompSum2.text.toString() //проверяет, является ли сумма чисел нечетной и RadioButton для нечетных чисел выбран.
                    .toInt() % 2 == 1 && binding.rbtnNotEvenComp2.isChecked
            ) {
                binding.imgComp.setImageResource(R.drawable.img_true)
                ++trueCounter
                dataModel.messageFromCompFragmentTrue.value = trueCounter.toString()
            } else {
                binding.imgComp.setImageResource(R.drawable.img_false)
                ++falseCounter
                dataModel.messageFromCompFragmentTrue.value = trueCounter.toString()
            }
        }
        return binding.root //возвращает корневой элемент View.
    }


    companion object {
        @JvmStatic
        fun newInstance() = CompFragment()
    }





    fun resetRadioButtons() {

        binding.rbtnEvenComp2.isEnabled = true
        binding.rbtnNotEvenComp2.isEnabled = true
        binding.rbtnEvenComp2.isChecked = false
        binding.rbtnNotEvenComp2.isChecked = false

        binding.txtNumCompFirst2.text = ""
        binding.txtNumCompSecond2.text = ""
        binding.txtNumCompThird2.text = ""
        binding.txtNumCompSum2.text = ""
        val userFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.FrameUser) as UserFragment
        userFragment.resetUserFields()

        rand()
        dataModel.messageForCompFragment.observe(activity as LifecycleOwner) {
            val btnClick = it.toString().toBoolean()
            if (btnClick) {
                binding.linearLayoutComp.isVisible = true
                binding.imgComp.isVisible = true
            }
        }

        binding.rbtnEvenComp2.setOnClickListener {//устанавливает слушатель клика на RadioButton для четных чисел.
            dataModel.messageFromCompFragment.value = rbClick.toString() //сохраняет значение клика в dataModel.
            binding.rbtnEvenComp2.isEnabled = false // отключает RadioButton для четных чисел после клика.
            binding.rbtnNotEvenComp2.isEnabled = false //отключает RadioButton для нечетных чисел после клика.
            ++allCounter //увеличивает счетчик общего числа попыток.
            //проверяет, является ли сумма чисел четной и RadioButton для четных чисел выбран.
            if (binding.txtNumCompSum2.text.toString().toInt() % 2 == 0 && binding.rbtnEvenComp2.isChecked)
            {
                binding.imgComp.setImageResource(R.drawable.img_true)
                ++trueCounter //увеличивает счетчик правильных ответов.
                dataModel.messageFromCompFragmentTrue.value = trueCounter.toString() // сохраняет значение счетчика правильных ответов в dataModel.
            } else {
                binding.imgComp.setImageResource(R.drawable.img_false) //станавливает изображение для неправильного ответа.
                ++falseCounter //увеличивает счетчик неправильных ответов.
                dataModel.messageFromCompFragmentTrue.value = trueCounter.toString() //сохраняет значение счетчика правильных ответов в dataModel.
            }
        }

        binding.rbtnNotEvenComp2.setOnClickListener {//устанавливает слушатель клика на RadioButton для нечетных чисел.
            dataModel.messageFromCompFragment.value = rbClick.toString()
            binding.rbtnEvenComp2.isEnabled = false
            binding.rbtnNotEvenComp2.isEnabled = false
            ++allCounter //увеличивает счетчик общего числа попыток.
            if (binding.txtNumCompSum2.text.toString() //проверяет, является ли сумма чисел нечетной и RadioButton для нечетных чисел выбран.
                    .toInt() % 2 == 1 && binding.rbtnNotEvenComp2.isChecked
            ) {
                binding.imgComp.setImageResource(R.drawable.img_true)
                ++trueCounter
                dataModel.messageFromCompFragmentTrue.value = trueCounter.toString()
            } else {
                binding.imgComp.setImageResource(R.drawable.img_false)
                ++falseCounter
                dataModel.messageFromCompFragmentTrue.value = trueCounter.toString()
            }
        }


    }

    @SuppressLint("SetTextI18n")
    fun rand() {
        binding.txtNumCompFirst2.text = (1..6).random().toString()
        binding.txtNumCompSecond2.text = (1..6).random().toString()
        binding.txtNumCompThird2.text = (1..6).random().toString()
        binding.txtNumCompSum2.text = (binding.txtNumCompFirst2.text.toString().toInt() +
                binding.txtNumCompSecond2.text.toString().toInt() +
                binding.txtNumCompThird2.text.toString().toInt()).toString()
    }
}
