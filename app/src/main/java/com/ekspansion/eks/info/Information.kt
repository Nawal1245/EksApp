package com.ekspansion.eks.info

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Information")
class Information (

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "ProfilePic")
    val ProfilePic: String,
    @ColumnInfo(name = "Banner")
    val Banner: String,
    @ColumnInfo(name = "BusinessName")
    val BusinessName: String,
    @ColumnInfo(name = "Biography")
    val Biography: String,
    @ColumnInfo(name = "WorkingHours")
    val WorkingHours: String

    )
