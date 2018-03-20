package com.kaellah.testuklonposts.util

import android.content.Context
import android.support.annotation.StringRes


infix fun Context.string(@StringRes stringRes: Int) = resources.getString(stringRes)!!
