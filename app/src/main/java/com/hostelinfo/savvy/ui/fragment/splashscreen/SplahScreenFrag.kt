package com.hostelinfo.savvy.ui.fragment.splashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mvvmsample.util.Coroutines
import com.hostelinfo.savvy.R
import com.hostelinfo.savvy.base.BaseFragment
import com.hostelinfo.savvy.data.sharedpreference.IS_LOGGED_IN
import com.hostelinfo.savvy.data.sharedpreference.PreferenceProvider
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class SplahScreenFrag() : BaseFragment(),KodeinAware {

    override val kodein by kodein()
    private val preference: PreferenceProvider by instance<PreferenceProvider>()
    private var job : Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splah_screen, container, false)
    }

    private suspend fun handleIntents(){
     delay(2000)
        if (preference.getsharedBoolean(IS_LOGGED_IN))
        {
           findNavController().navigate(R.id.action_splahScreenFrag_to_loginFragment)
        }
    }
    override fun onResume() {
        super.onResume()
        if (job == null)
            job = Coroutines.main {
                handleIntents()
            }
    }

        override fun onPause() {
            super.onPause()
            if (job != null) {
                job?.cancel()
                job = null
            }
//        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
//        activity?.window?.decorView?.systemUiVisibility = 0

        }


}