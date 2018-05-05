package com.example.logonrm.meusjogosfavoritos

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.logonrm.meusjogosfavoritos.adapter.JogoAdapter
import com.example.logonrm.meusjogosfavoritos.model.Jogo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvJogos.adapter = JogoAdapter(this, getJogos(), {
            val intentDetalhe = Intent(this, DetalheActivity::class.java)

            intentDetalhe.putExtra("jogo", it)

            startActivity(intentDetalhe)
        }, {
            Toast.makeText(this, "Delete ${it.titulo}", Toast.LENGTH_LONG).show()
        })
        rvJogos.layoutManager = LinearLayoutManager(this)
    }

    fun getJogos(): List<Jogo>{
        return listOf(
                Jogo(getString(R.string.titulo_mortal_kombat),
                        getString(R.string.descricao_mortal_kombat),
                        2018,
                        R.drawable.mortalkombat,
                        R.drawable.mk_bk)
        )
    }
}
