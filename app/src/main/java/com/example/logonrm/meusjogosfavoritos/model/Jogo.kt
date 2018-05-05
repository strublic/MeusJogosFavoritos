package com.example.logonrm.meusjogosfavoritos.model

import android.os.Parcel
import android.os.Parcelable

data class Jogo(val titulo: String,
                val descricao: String,
                val anoLancamento: Int,
                val fotoId: Int,
                val bannerId: Int): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeString(descricao)
        parcel.writeInt(anoLancamento)
        parcel.writeInt(fotoId)
        parcel.writeInt(bannerId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Jogo> {
        override fun createFromParcel(parcel: Parcel): Jogo {
            return Jogo(parcel)
        }

        override fun newArray(size: Int): Array<Jogo?> {
            return arrayOfNulls(size)
        }
    }
}