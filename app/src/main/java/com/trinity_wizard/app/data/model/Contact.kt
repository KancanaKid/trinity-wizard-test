package com.trinity_wizard.app.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author basyi
 * Created 5/16/2023 at 3:57 PM
 */

data class Contact(
    @SerializedName("id")
    val id:String,
    @SerializedName("firstName")
    val firstName:String,
    @SerializedName("lastName")
    val lastName:String,
    @SerializedName("email")
    val email:String,
    @SerializedName("dob")
    val dob:String):Serializable
