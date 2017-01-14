package apirest

import grails.converters.JSON
import grails.rest.RestfulController

import java.text.DateFormat
import java.text.SimpleDateFormat

class UsuarioController extends RestfulController<Usuario> {

    @Override
    def index() {
        render status: 200, text: 'Usuario API running OK.'
    }

    @Override
    def show() {
        render Usuario.list() as JSON
    }

    @Override
    def create() {
        def jsonObj = request.JSON
        Usuario u = new Usuario(jsonObj.dni, jsonObj.nombre, jsonObj.email, jsonObj.nacimiento)
        u.save()
        render u as JSON
    }

    def edad() {
        // filtro usuarios por edad
        /*def edad = params.action
        def usuarios = []
        def edadUsuario
        def hoy = new Date()
        Usuario.list().each { u ->
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            Date date = format.parse(u.nacimiento)
            println (hoy[Calendar.YEAR] - date[Calendar.YEAR])
        }
        render usuarios as JSON*/
    }


}
