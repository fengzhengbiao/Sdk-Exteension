package com.leopard.extension

import android.text.TextUtils
import java.security.MessageDigest


fun String.md5(): String {
    val result = MessageDigest.getInstance("MD5").digest(this.toByteArray())
    return with(StringBuilder()) {
        result.forEach {
            val hex = it.toInt() and (0xFF)
            val hexStr = Integer.toHexString(hex)
            if (hexStr.length == 1) {
                this.append("0").append(hexStr)
            } else {
                this.append(hexStr)
            }
        }
        this.toString()
    }
}


fun String?.isMobile(): Boolean {
    val telRegex = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$"
    return !TextUtils.isEmpty(this) && this!!.matches(Regex(telRegex))
}


