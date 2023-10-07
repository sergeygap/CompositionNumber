package com.gap.compositionnumber.domain.entities

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class GameSettings(
    val valueMaxSum: Int,
    val minCountOfRightAnswers: Int,
    val minPercentOfRightAnswers: Int,
    val gameTimeInSecond: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(valueMaxSum)
        parcel.writeInt(minCountOfRightAnswers)
        parcel.writeInt(minPercentOfRightAnswers)
        parcel.writeInt(gameTimeInSecond)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GameSettings> {
        override fun createFromParcel(parcel: Parcel): GameSettings {
            return GameSettings(parcel)
        }

        override fun newArray(size: Int): Array<GameSettings?> {
            return arrayOfNulls(size)
        }
    }
}
