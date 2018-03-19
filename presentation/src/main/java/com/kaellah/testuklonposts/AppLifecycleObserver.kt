package com.kaellah.testuklonposts

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import javax.inject.Inject

/**
 * @since 03/19/2018
 */
class AppLifecycleObserver @Inject constructor(private val context: Context) : LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onExitForeground() {
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onEnterForeground() {
    }

}