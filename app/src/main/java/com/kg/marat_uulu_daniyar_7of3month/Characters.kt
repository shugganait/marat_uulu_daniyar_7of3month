package com.kg.marat_uulu_daniyar_7of3month

import android.os.Parcel
import android.os.Parcelable

data class Characters(
    val picture: String? = "",
    val status: String? = "неизвестно",
    val name: String? = "неизвестно",
    val tinyInfo: String? = "неизвестно"
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(picture)
        parcel.writeString(status)
        parcel.writeString(name)
        parcel.writeString(tinyInfo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Characters> {
        override fun createFromParcel(parcel: Parcel): Characters {
            return Characters(parcel)
        }

        override fun newArray(size: Int): Array<Characters?> {
            return arrayOfNulls(size)
        }
    }

}
