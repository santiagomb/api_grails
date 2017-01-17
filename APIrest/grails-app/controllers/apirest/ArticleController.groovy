package apirest

import grails.converters.JSON
import grails.rest.RestfulController
import org.springframework.dao.DataIntegrityViolationException

import javax.servlet.http.HttpServletResponse

class ArticleController extends RestfulController<Article> {

    static responseFormats = ['json']

    ArticleController(){
        super(Article)
    }

    @Override
    def index() {
        render ([status: 200, message: 'Article API running OK.'] as JSON)
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
    // curl -i -X DELETE localhost:8080/APIrest/article/delete/2
    // curl -i -X PUT -H "Content-Type: application/json" -d '{"title":"Along Came A Spider", contenido: "contenido actualizado", visitas: 3, comentarios:}' localhost:8080/books/1

    @Override
    def delete(){
        def article = Article.get(params.id)
        if(!article){
            render ([status: 404, error: "not found", message: "article id " + params.id + " not found"] as JSON)
        }
        try {
            article.delete()
            render ([status: 200, message: "article id " + params.id + " deleted"] as JSON)
        }
        catch (DataIntegrityViolationException e){
            render ([status: 500, error: "internal error", message: "could not delete article id" + params.id] as JSON)
        }
    }

    def comment(){
        Article a = Article.get(params.id)
        if(!a){
            render ([status: 404, error: "not found", message: "article id " + params.id + " not found"] as JSON)
        }
        try {
            def jsonObj = request.JSON
            String comentario = jsonObj.comentario
            a.comentarios.add(comentario)
            a.save()
            render a as JSON
        }
        catch (DataIntegrityViolationException e){
            render ([status: 500, error: "internal error", message: "could not comment article id" + params.id] as JSON)
        }
    }

    def visit(){
        Article a = Article.get(params.id)
        if(!a){
            render ([status: 404, error: "not found", message: "article id " + params.id + " not found"] as JSON)
        }
        try {
            a.visitas ++
            a.save()
            render a as JSON
        }
        catch (DataIntegrityViolationException e){
            render ([status: 500, error: "internal error", message: "could not visit article id" + params.id] as JSON)
        }
    }

    @Override
    def update() {
        Article a = Article.get(params.id)
        if(!a){
            render ([status: 404, error: "not found", message: "article id " + params.id + " not found"] as JSON)
        }
        try {
            a.properties = params
            a.save()
            render a as JSON
        }
        catch (DataIntegrityViolationException e){
            render ([status: 500, error: "internal error", message: "could not update article id" + params.id] as JSON)
        }
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
