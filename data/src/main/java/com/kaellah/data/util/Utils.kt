package com.kaellah.data.util

import android.support.annotation.WorkerThread
import timber.log.Timber
import java.net.InetSocketAddress
import java.net.Socket

/**
 * @since 03/19/2018
 */
object Utils {

    @JvmStatic
    @WorkerThread
    fun isOnline(): Boolean {
        try {
            val timeout = 1500
            val sock = Socket()
            val sockAddr = InetSocketAddress("8.8.8.8", 53)
            sock.connect(sockAddr, timeout)
            sock.close()

            return true
        } catch (ex: Exception) {
            Timber.e(ex)
        }
        return false
    }
}