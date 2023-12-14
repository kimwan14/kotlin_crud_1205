package com.example.kotiln_1205_crud.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotiln_1205_crud.R
import com.example.kotiln_1205_crud.USER.UserTable
import com.example.kotiln_1205_crud.USER.UserViewModel
import com.example.kotiln_1205_crud.databinding.FragmentAddBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {
    private lateinit var _userViewModel: UserViewModel
    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater,container,false)
        _userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.addButton.setOnClickListener {
            val _name = binding.name.text.toString()
            val _job = binding.job.text.toString()
            val _age = binding.age.text.toString()

            if (_name.isNotEmpty() && _job.isNotEmpty() && _age.isNotEmpty()) {
                CoroutineScope(Dispatchers.IO).launch {
                    _userViewModel.addUser(UserTable(name = _name, job = _job, age = _age))

                }
            }

        }
        return TODO("Provide the return value")
    }


}