package apirest

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UsuarioController)
class UsuarioControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        given:
            def u = Mock(Usuario)

        when:
            def result = u.ObtenerEdad()

        then:
            result == "algo"
    }
}
