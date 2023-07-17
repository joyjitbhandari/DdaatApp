package com.example.ddaatapp.utils

import com.example.ddaatapp.model.responseDatamodel.ProfileData
import com.flynaut.healthtag.util.PrefsManager
import com.google.gson.Gson

object SavedData {
    val profileData: ProfileData = Gson().fromJson(
        PrefsManager.get().getString(PrefsManager.PREF_PROFILE, ""),
        ProfileData::class.java)
//
//    var profileData: ProfileData
//        get() {
//            val jsonString = PrefsManager.get().getString(PrefsManager.PREF_PROFILE, "")
//            return Gson().fromJson(jsonString, ProfileData::class.java)
//        }
//        set(value) {
//            val jsonString = Gson().toJson(value)
//            PrefsManager.get().save(PrefsManager.PREF_PROFILE, jsonString)
//        }
}
