package com.example.kotiln_1205_crud.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotiln_1205_crud.ARG_PARAM1
import com.example.kotiln_1205_crud.ARG_PARAM2
import com.example.kotiln_1205_crud.R
import com.example.kotiln_1205_crud.USER.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.age
import kotlinx.android.synthetic.main.fragment_add.job
import kotlinx.android.synthetic.main.fragment_add.name
import kotlinx.android.synthetic.main.fragment_add.view.addButton

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
                _userViewModel.addUser(userTable = (name = _name,))
            }

        }
    }


}