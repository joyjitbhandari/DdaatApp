package com.example.ddaatapp.utils

import com.example.ddaatapp.model.responseDatamodel.ProfileData
import com.flynaut.healthtag.util.PrefsManager
import com.google.gson.Gson

object SavedData {
    val profileData: ProfileData = Gson().fromJson(
        PrefsManager.get().getString(PrefsManager.PREF_PROFILE, ""),
        ProfileData::class.java)
}
