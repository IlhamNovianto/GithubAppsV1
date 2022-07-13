package com.example.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubuserapp.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {

    //Mengikat Activity detail user dengan variable Binding
    private lateinit var binding: ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //memanggil data User yang terlah terParcelized (User)
        val person = intent.getParcelableExtra<User>(DETAIL_USER) as User
        // menginisialisasi id detailUser.xml dengan data User Parcelize agar dapat ditampilkan di activity baru
        binding.apply {
            userNameId.text = person.userTnameToParc
            userName.text = person.userNameToParc
            userLocation.text = person.userLocationToParc
            userFolower.text = person.userFollingToParc
            userFolower.text = person.userFollerToParc
            userReposistory.text = person.userReposToParc
            userCompany.text = person.userCompanyToParc
            userAvatar.setImageResource(person.userAvatarToParc)
        }
    }

    companion object {
        const val DETAIL_USER = "detail_user"
    }
}