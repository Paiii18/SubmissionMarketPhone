package com.example.submissionakhiraplikasipemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var HP: RecyclerView
    private val list = ArrayList<HP>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HP = findViewById(R.id.hp)
        HP.setHasFixedSize(true)

        list.addAll(getListHP())
        showRecylerList()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                val moveIntent = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(moveIntent)
            }

            }

        return super.onOptionsItemSelected(item)
    }


    private fun getListHP(): ArrayList<HP> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val listHP = ArrayList<HP>()
        for (i in dataName.indices) {
            val HP = HP(dataName[i],dataDescription[i],dataPhoto.getResourceId(i,-1),dataPrice[i])
            listHP.add(HP)
        }

        return listHP
    }

    private fun showRecylerList(){
        HP.layoutManager = LinearLayoutManager(this)
        val listHPAdapter = ListHPAdapter(list)
        HP.adapter = listHPAdapter

        listHPAdapter.setOnItemClickCallback(object : ListHPAdapter.OnItemClickCallback {
            override fun onItemClicked(data: HP) {
                val moveWithObjectIntent = Intent(this@MainActivity, DetailHp::class.java)
                moveWithObjectIntent.putExtra(DetailHp.EXTRA_HP, data)
                startActivity(moveWithObjectIntent)
            }
        })

    }
}