package com.example.mine.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mine.R
import com.example.mine.data.db.entities.entites.User
import com.example.mine.databinding.ActivityMainBinding
import com.example.mine.utils.hide
import com.example.mine.utils.show
import com.example.mine.utils.snackbar
import com.example.mine.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(),AuthListener,KodeinAware {
    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this,factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListner = this

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if(user != null){
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })


    }


    override fun onStarted() {
        progress_bar.show()
       }
    override fun onSuccess(user:User) {
        progress_bar.hide()

         }

    override fun onFailure(message : String) {
        progress_bar.hide()
        root_layout.snackbar(message)
     }
}
