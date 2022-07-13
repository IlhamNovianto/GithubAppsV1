package com.example.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// (:/extend) adalah penurunan sifat atau object yang dimiliki kelas sebelumnya
class MainActivity : AppCompatActivity() {

     private lateinit var listUser: RecyclerView //Inisialisasi Object ke dalam Model Recycleview (listuser extend Recycleview)
     private val list = ArrayList<User>() // list adalah memasukan data dari Source Ke User.kt untuk parcelized

    override fun onCreate(savedInstanceState: Bundle?) { //Mulai membangun Aplikasi. SaveInstanceState adalah penyimpan ketika kongfigurasi berpindah
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //Dan di set untuk menampilkan konten pada layout "activity_main.xml"

        listUser = findViewById(R.id.list_users)//listUser yang memiliki view Recycle, di inisialisasikan dengan memanggil id dari RecycleView
        listUser.setHasFixedSize(true) //mengantisipasi terjadinya CollapsingToolbarLayout, yaitu ketika di scroll maka akan mengecil
        list.addAll(listUsers)//list yang berupa Array Resourcedata, akan menampilkan semua data ke listUser(RecycleView)
        showRecyclerList() //mengembalikan nilai kongfigurasi dari setting di atas
    }

    private  val listUsers: ArrayList<User> //listUser adalh variable yang berisi nilai array (User)
    get(){//GET, fungsinya untuk mengambil data dari Array User
        // nama variable = resources.get String array dari String.xml | (R.Array.id String Array)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataLocation =  resources.getStringArray(R.array.location)
        val dataCompany =  resources.getStringArray(R.array.company)
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataReposistory =  resources.getStringArray(R.array.repository)
        val dataFolling =  resources.getStringArray(R.array.following)
        val dataFoller =  resources.getStringArray(R.array.followers)
        val dataTname =  resources.getStringArray(R.array.name)
        val listUserArray = ArrayList<User>()

        for (i in dataUsername.indices){ //indices = Mengembalikan rentang indeks yang valid untuk array. (ArrayRange)
            val user = User(dataUsername[i], dataLocation[i], dataCompany[i], dataAvatar.getResourceId(i, -1),
            dataReposistory[i], dataFolling[i], dataFoller[i], dataTname[i])
            listUserArray.add(user)//Proses pembentukan/memasukan penjabaran data Array untuk Parcelized di User.kt
        }
        return listUserArray //mengembalikan ArrayList
    }

    private fun showRecyclerList(){
        //listUser=Recycler, mengatur tampilan dari Recycle berbentuk Linier (this = dalam koteks Halaman ini)
        listUser.layoutManager = LinearLayoutManager(this)
        val userRow = UserRowAdapter(list)// menyambungkan antara UserAdapter dari Source Array String.xml
        listUser.adapter = userRow //RecyclerView ADAPTER == userRow

        userRow.setOnItemClick(object : UserRowAdapter.OnItemClickBacktoo {
            override fun onCliked(data: User) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: User){
        val intent = Intent(this@MainActivity, DetailUserActivity::class.java)
        intent.putExtra(DetailUserActivity.DETAIL_USER,user)
        startActivity(intent)
    }

}