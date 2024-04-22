package sv.edu.ufg.fis.amb.guzmanangulo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Fragmento2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val vista = inflater.inflate(R.layout.fragment_2, container, false)
        val textoRecibido = arguments?.getString(ARG_TEXTO)
        vista.findViewById<TextView>(R.id.textoRecibido).text = textoRecibido
        return vista
    }

    companion object {
        private const val ARG_TEXTO = "texto"

        fun nuevaInstancia(texto: String): Fragmento2 {
            val fragmento = Fragmento2()
            val args = Bundle().apply {
                putString(ARG_TEXTO, texto)
            }
            fragmento.arguments = args
            return fragmento
        }
    }
}
