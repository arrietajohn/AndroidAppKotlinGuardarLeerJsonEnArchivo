package co.gov.mintic.misiontic.udea.ciclo4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.EditText
import android.widget.TextView
import co.gov.mintic.misiontic.udea.ciclo4.archivojson.ControladorAchivoJson
import co.gov.mintic.misiontic.udea.ciclo4.datos.Usuario
import java.io.File

class MainActivity : AppCompatActivity() {
    private var textView: TextView?=null;
    private var stringBuilder:StringBuilder?=null
    private var listaUsuarios = mutableListOf<Usuario>()
    val nombreArchivo = "datos.txt"
    //private val nombreArchivo = "datos.txt"
    private val controldor = ControladorAchivoJson()
    private var archivo : File? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_principal)
          archivo = File(this.applicationContext.filesDir, nombreArchivo)
         if ( !archivo!!.exists()){
             archivo!!.createNewFile()
         }


    }

    fun guardarUsuario(v :View) : Unit{
        val campoCc = findViewById<EditText>(R.id.campoCedula)
        val campoNom = findViewById<EditText>(R.id.campoNombre)
        val campoEdad = findViewById<EditText>(R.id.campoEdad)
        var user = Usuario(campoCc.text.toString(), campoNom.text.toString(), campoEdad.text.toString().toInt())
        listaUsuarios.add(user)
        val etiJson = findViewById<TextView>(R.id.txtDatos2)
        controldor.guardarJsonEnArchivo(archivo!!,listaUsuarios)
    }

    fun recuperarUsuario(v :View) : Unit{
        var listaUsuario = controldor.recuperarJsonDeArchivo(archivo!!)
        val etiJson = findViewById<TextView>(R.id.txtDatos2)
        var datos = ""
        for (u in listaUsuario){
            datos += "${u.nombre}\n"
        }
        etiJson.text = datos

    }
}