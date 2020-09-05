package com.hostelinfo.savvy.ui.fragment.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hostelinfo.savvy.R
import com.hostelinfo.savvy.base.BaseFragment
import com.hostelinfo.savvy.data.sharedpreference.PreferenceProvider
import io.reactivex.internal.operators.maybe.MaybeToPublisher.instance
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class LoginFragment : BaseFragment(),LoginHandle,KodeinAware {
    override val kodein by kodein()


    private lateinit var viewModel: LoginViewModel
    private val preference: PreferenceProvider by instance()
   // private val factory=LoginViewModelFactory by instance<LoginViewModelFactory>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       this.viewModel= ViewModelProvider(this).get(LoginViewModel::class.java)
       viewModel.loginHandler =this
        return inflater.inflate(R.layout.lofin_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

}