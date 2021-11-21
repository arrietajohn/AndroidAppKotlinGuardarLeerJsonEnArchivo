package co.gov.mintic.misiontic.udea.ciclo4.datos

class Usuario {
    var cedula : String? = null
    var nombre : String? = null
    var edad : Int? = null

    // constructores

    // Contructor por defecto
    constructor() : super(){}

    // constructor con parametros
    constructor(cedula:String, nombre:String, edad :Int){
        this.cedula = cedula
        this.nombre = nombre
        this.edad = edad
    }
}