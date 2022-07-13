package com.example.githubuserapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubuserapp.databinding.UserRowBinding

/*
Adaptor bertanggung jawab untuk mengambil data dari kumpulan data dan
untuk menghasilkan View objects berdasarkan data tersebut. View Objek
yang dihasilkan kemudian digunakan untuk mengisi tampilan adaptor yang terikat ke adaptor.
 */
//                               berisi data Parcelized extend nama tampilan. adapter<nama class ini dengan holder>
class UserRowAdapter(private val rowUser: ArrayList<User>) : RecyclerView.Adapter<UserRowAdapter.ListViewHolder>(){

    class ListViewHolder(var binding: UserRowBinding) : RecyclerView.ViewHolder(binding.root)

    //Membuat fungsi Click ketika memilih user
    private lateinit var onItemClickBack: OnItemClickBacktoo //OnItemClickBacktoo Interface
        fun setOnItemClick(onItemClickBack: OnItemClickBacktoo){
            this.onItemClickBack = onItemClickBack
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(UserRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    //Proses pengikatan antara id User_row.xml dengan DATA CLASS Parcelized(User.kt)
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        //memilih cariable apa saja yang akan di tampilkan sesuai dengan id user_row.kt
        val (userNameAdpt, locationAdpt, companyAdpt, avatarAdpt) = rowUser[position]

        holder.binding.apply {
            userAvatarMain.setImageResource(avatarAdpt)
            userNameMain.text = userNameAdpt
            userLocationMain.text = locationAdpt
            userCompanyMain.text = companyAdpt
            //listUser ini adalah ID yang berada di main_activity.xml
            listUsers.setOnClickListener{
                onItemClickBack.onCliked(rowUser[holder.adapterPosition])
            }
        }
    }

    override fun getItemCount(): Int = rowUser.size

    interface OnItemClickBacktoo {
        fun onCliked(data: User)
    }
}