package com.ekspansion.eks.info

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface InformationDAO {
    @Query("SELECT * From Information")
   fun getInformation(): LiveData<List<Information>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(information: Information)

}