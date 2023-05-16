package com.trinity_wizard.app.data.util

import android.content.Context
import android.net.Uri
import android.util.Log
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.trinity_wizard.app.data.model.Contact
import java.io.File
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

fun writeData(context:Context, contact: Contact):Int{
    val uri = Uri.parse("file:///android_asset/raw/data.json")
    return try {
        val mapper = ObjectMapper()
        mapper.writeValue(File(uri.toString()), contact)
        1
    }catch (e:IOException){
        Log.i("result","${e.message}")
        e.printStackTrace()
        0
    }
}