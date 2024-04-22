package sv.edu.ufg.fis.amb.guzmanangulo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class Fragmento1 : Fragment() {

    private var listener: InteraccionConFragmentoListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val vista = inflater.inflate(R.layout.fragment_1, container, false)
        vista.findViewById<Button>(R.id.botonEnviar).setOnClickListener {
            val texto = vista.findViewById<EditText>(R.id.editTexto).text.toString()
            listener?.onTextoEnviado(texto)
        }
        return vista
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is InteraccionConFragmentoListener) {
            listener = context
        } else {
            throw RuntimeException("$context debe implementar InteraccionConFragmentoListener")
        }
    }

    interface InteraccionConFragmentoListener {
        fun onTextoEnviado(texto: String)
    }

    companion object {
        fun newInstance() = Fragmento1()
    }
}
