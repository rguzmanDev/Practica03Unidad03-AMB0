package sv.edu.ufg.fis.amb.guzmanangulo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), Fragmento1.InteraccionConFragmentoListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            cambiarFragmento(Fragmento1(), false)
        }
    }

    private fun cambiarFragmento(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contenedor_fragmento, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    override fun onTextoEnviado(texto: String) {
        cambiarFragmento(Fragmento2.nuevaInstancia(texto), true)
    }
}
