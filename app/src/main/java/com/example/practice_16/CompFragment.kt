package com.example.practice_16

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.practice_16.databinding.FragmentCompBinding
import kotlin.properties.Delegates

class CompFragment : Fragment() {
    lateinit var binding: FragmentCompBinding
    var radio by Delegates.notNull<Int>()
    var count = 0 //кол-во баллов, которые отправляю

    private  val dataModel: DataModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageFromActivityRandList.observe(activity as LifecycleOwner){
            binding.randvalue.text = it //получили значение
        }
        dataModel.messageFromActivityRandListSum.observe(activity as LifecycleOwner){
            binding.Sum.text = it
        }
        binding.radioButton3.setOnClickListener{
            dataModel.BtnCheckenabled.value = true
            radio = 1
        }
        binding.radioButton4.setOnClickListener{
            dataModel.BtnCheckenabled.value = true
            radio = 2
        }
        dataModel.messageFromActivityResultFromComp.observe(activity as LifecycleOwner) {
            if (radio == 1) {
                binding.imageView2.isVisible = true
                binding.radioButton3.isChecked = true
                binding.imageView3.isVisible = false
                if (radio == it) { //проверка на четноесть и нечетность
                    binding.imageView2.setImageResource(R.drawable.img_true)
                    count++
                } else {
                    binding.imageView2.setImageResource(R.drawable.img_false)
                }
            } else {
                binding.imageView3.isVisible = true
                binding.radioButton4.isChecked = true
                binding.imageView2.isVisible = false
                if (radio == it) {
                    binding.imageView3.setImageResource(R.drawable.img_true)
                    count++
                } else {
                    binding.imageView3.setImageResource(R.drawable.img_false)
                }
            }
            dataModel.messageCountForComp.value = count.toString() //отправляю счетчик
        }
    }

    companion object{
        @JvmStatic
        fun newInstance() = CompFragment() //чтобы работал дата модэл
    }
}
