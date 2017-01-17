package apirest

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ArticleController)
@Mock(Article)
class ArticleControllerSpec extends Specification {

    def setup() {
        new Article(title: "Título de test", contenido: "Esto es un testeo",
                autor: "Admin", visitas: 0, comentarios: ["Testing1", "Testing2"]).save()
    }

    def cleanup() {
    }

    void "test show"() {
        when:
            controller.show()

        then:
            Article.list().size() == 1
    }

    void "test create"() {
        when:
            controller.create()

        then:
            println "hola"
    }

}
