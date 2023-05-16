package com.trinity_wizard.app.data.util

import android.content.Context
import java.io.IOException

/**
 * @author basyi
 * Created 5/16/2023 at 4:00 PM
 */

fun readDataFromJson(context:Context, fileName:String):String? {
    val jsonString:String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}