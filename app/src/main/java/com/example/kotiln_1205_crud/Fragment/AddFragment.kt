package com.example.kotiln_1205_crud.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotiln_1205_crud.R
import com.example.kotiln_1205_crud.USER.UserTable
import com.example.kotiln_1205_crud.USER.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.age
import kotlinx.android.synthetic.main.fragment_add.job
import kotlinx.android.synthetic.main.fragment_add.name
import kotlinx.android.synthetic.main.fragment_add.view.addButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {
  private lateinit var  _userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_add,container,false)

        _userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.addButton.setOnClickListener{
            val _name = name.text.toString()
            val _job = job.text.toString()
            val _age = age.text.toString()

            if(_name.isNotEmpty()&&_job.isNotEmpty()&&_age.isNotEmpty()){
                CoroutineScope(Dispatchers.IO).launch {
                    _userViewModel.addUser(UserTable(name = _name, job = _job, age = _age, id = 0))
                    Toast.makeText(
                        requireContext(),
                        "Name:${_name} Job:${_job} Age:${_age} 가입 완료 ",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }else{
                Toast.makeText(
                    requireContext(),
                    "입력하지 않은 부분이 있는지 확인하세요",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        return TODO("Provide the return value")
    }


}