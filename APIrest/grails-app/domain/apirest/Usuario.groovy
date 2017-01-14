package apirest

import grails.rest.Resource

@Resource(formats = ['json', 'xml'])
class Usuario {

    String dni
    String nombre
    String email
    String nacimiento

    Usuario(String dni, String nombre, String email, String nacimiento){
        this.dni = dni
        this.nombre = nombre
        this.email = email
        this.nacimiento = nacimiento
    }

    static constraints = {
    }
}
