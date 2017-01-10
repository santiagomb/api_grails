package apirest

import grails.converters.JSON

import javax.servlet.http.HttpServletResponse

class ArticleController {

    def index() {
        render status: 200, text: 'Article API running OK.'
    }

    def show() {
        render Article.list() as JSON
    }

    def create() {
        Article a = new Article(params)
        a.save()
        render a as JSON
    }

    def delete(){
        Article.get(params.id)?.delete()
        render status: HttpServletResponse.SC_NO_CONTENT
    }

    def update() {
        Article a = Article.get(params.id)
        a.properties = params
        a.save()
        render a as JSON
    }
}
