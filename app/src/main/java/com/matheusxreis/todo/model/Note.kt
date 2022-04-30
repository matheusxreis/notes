package com.matheusxreis.todo.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize
import java.util.*


@Parcelize
data class Note(
    val title:String,
    val createdAt: Date? = Calendar.getInstance().time,
    val description:String? = "Sem descrição",
    val done: Boolean? = false,
    val id: String? = setId(),
    val important: Boolean = false,
    ): Parcelable



fun setId():String{
    return (1..999).toList().random().toString()
}