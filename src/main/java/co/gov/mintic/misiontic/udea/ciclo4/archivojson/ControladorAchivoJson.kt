package co.gov.mintic.misiontic.udea.ciclo4.archivojson

import co.gov.mintic.misiontic.udea.ciclo4.datos.Usuario
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.File

class ControladorAchivoJson {



    public fun guardarJsonEnArchivo(archivo :File, listaUsuarios: List<Usuario>) : Unit {
        var listaJson = converterLisaUsuriousAJson(listaUsuarios)
        //abrimos el archivo
        // escribirmos los datos en el archivo
        archivo.writeText(listaJson)
    }


    public fun recuperarJsonDeArchivo(archivo :File) : List<Usuario>{
        //abrimos el archivo
        // recuperarmos los datos dentro del archivo
       // var listaJson = archivo.readText()
        val br: BufferedReader = archivo.bufferedReader()
        // reconstruimos el JSON a Lista de Usuarios
        // leemos todos el contenido del archivo
        val  listaJson = br.use { it.readText() }
        return reconstructJsonArrayAListUsuario(listaJson)
    }


    private fun converterAJson(user: Usuario) : String{
        return Gson().toJson(user)
    }


    private fun converterLisaUsuriousAJson(listaUsuarios: List<Usuario>) : String{
        return Gson().toJson(listaUsuarios)
    }

    private fun reconstructJsonAUsual(usuarioJson : String): Usuario{
        return Gson().fromJson<Usuario>(usuarioJson, Usuario::class.java)
    }

    private fun reconstructJsonArrayAListUsuario(usuarioArrayJson: String) : List<Usuario>{
        val tipo = object : TypeToken<List<Usuario>>() { }.type
        return Gson().fromJson<List<Usuario>>(usuarioArrayJson, tipo)
    }

}