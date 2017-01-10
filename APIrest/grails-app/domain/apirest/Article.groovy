package apirest

import grails.rest.*

@Resource(formats = ['json', 'xml'])
class Article {

    String title
    String contenido
    String autor
    Integer visitas
    String[] comentarios

    static constraints = {
        title blank: false
        contenido blank: false
        autor blank: false
    }
}