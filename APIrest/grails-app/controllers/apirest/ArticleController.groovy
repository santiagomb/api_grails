package apirest

import grails.converters.JSON
import grails.rest.RestfulController

import javax.servlet.http.HttpServletResponse

class ArticleController extends RestfulController<Article> {

    static responseFormats = ['json']

    ArticleController(){
        super(Article)
    }

    @Override
    def index() {
        render status: 200, text: 'Article API running OK.'
    }

    @Override
    def show() {
        render Article.list() as JSON
    }

    @Override
    def create() {
        Article a = new Article(params)
        a.save()
        render a as JSON
    }

    // curl -i -X POST -H "Content-Type: application/json" -d '{"dni": "36155366", "nombre": "Santiago", "email":"asd@asjd.com", "nacimiento": "03/03/1990"}' localhost:8080/APIrest/usuario/create


    @Override
    def delete(){
        Article.get(params.id)?.delete()
        render status: HttpServletResponse.SC_NO_CONTENT
    }

    @Override
    def update() {
        Article a = Article.get(params.id)
        a.properties = params
        a.save()
        render a as JSON
    }

    @Override
    def author() {
        def author = params.id
        def authorArticles = []
        Article.list().each { a ->
            if (a.autor.nombre == author){
                authorArticles << a.title
            }
        }
        render authorArticles as JSON
    }
}
