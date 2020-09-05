package com.hostelinfo.savvy.ui.fragment.splashscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hostelinfo.savvy.utilities.coroutine.Coroutines
import com.hostelinfo.savvy.R
import com.hostelinfo.savvy.base.BaseFragment
import com.hostelinfo.savvy.data.sharedpreference.IS_LOGGED_IN
import com.hostelinfo.savvy.data.sharedpreference.PreferenceProvider
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import timber.log.Timber


class SplashScreenFrag() : BaseFragment(),KodeinAware {

    override val kodein by kodein()
    private val preference: PreferenceProvider by instance<PreferenceProvider>()
    private var job : Job? = null
    val activityScope = CoroutineScope(Dispatchers.Main)
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
        Timber.d("======This is working before ========")
            delay(3000)

        Timber.d("======This is working========")
        if (preference.getsharedBoolean(IS_LOGGED_IN))
        {
            Timber.d("======This is working========")

           findNavController().navigate(R.id.action_splahScreenFrag_to_loginFragment)
        }
    }
    override fun onResume() {
        super.onResume()
           Timber.d("=====Inside on Resume======")
        if (job == null)
            Timber.d("=====Inside if======")
            job = CoroutineScope(Main).launch {
                Timber.d("=====Before coro======")
                handleIntents()
                Timber.d("=====After coro======")
            }
    }

//        override fun onPause() {
//            super.onPause()
//            if (job != null) {
//                job?.cancel()
//                job = null
//            }
//        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
//        activity?.window?.decorView?.systemUiVisibility = 0

        }


