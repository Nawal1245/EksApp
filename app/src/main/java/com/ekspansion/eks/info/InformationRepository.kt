package com.ekspansion.eks.info

import android.widget.ImageView
import androidx.lifecycle.LiveData

class InformationRepository (private val informationDAO: InformationDAO){

    val allInformation: LiveData<List<Information>> = informationDAO.getInformation()

    fun insert(information: Information) {
        AppDatabase.databaseWriteExecutor.execute {
            informationDAO.insert(information)
        }
    }




}