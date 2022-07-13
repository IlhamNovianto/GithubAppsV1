package com.example.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


//Class ini berfungsi untuk menyimpan model data suatu obyek
@Parcelize
data class User(
    var userNameToParc: String?,
    var userLocationToParc: String?,
    var userCompanyToParc: String?,
    var userAvatarToParc: Int,
    var userReposToParc: String?,
    var userFollingToParc: String?,
    var userFollerToParc: String?,
    var userTnameToParc: String?
    ) : Parcelable