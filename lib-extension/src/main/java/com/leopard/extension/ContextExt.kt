package com.leopard.extension

import android.content.Context
import android.view.View

fun Context.setViewClick(listener: View.OnClickListener, vararg views: View) {
    views.forEach { it.setOnClickListener(listener) }
}