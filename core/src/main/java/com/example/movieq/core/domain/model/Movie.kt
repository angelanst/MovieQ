package com.example.movieq.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    val id: Long,
    val title: String,
    val description: String,
    val date: String,
    val rating: Double,
    val poster: String,
    val favorite: Boolean
) : Parcelable