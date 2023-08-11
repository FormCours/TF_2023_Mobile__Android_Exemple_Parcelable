package be.tftic.web2023.test_parcelable.models

import android.os.Parcel
import android.os.Parcelable

// Pour réaliser l'implementation de "Parcelable", utiliser l'option "Add Parcelable Implementation"
data class ExampleData(val firstname: String, val lastname: String, val number: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) { }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstname)
        parcel.writeString(lastname)
        parcel.writeInt(number)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExampleData> {
        override fun createFromParcel(parcel: Parcel): ExampleData {
            return ExampleData(parcel)
        }

        override fun newArray(size: Int): Array<ExampleData?> {
            return arrayOfNulls(size)
        }
    }
}
