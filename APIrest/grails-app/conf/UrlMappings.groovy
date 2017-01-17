class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(view:"/index")
        "/articles/$controller" (controller: "ArticleController"){
            action = [GET: 'show', POST: 'create']
        }
        "/articles/$controller/$id" (controller: "ArticleController"){
            action = [DELETE: 'delete', PUT: 'update', GET: 'visit', GET: 'author', PUT: 'comment']
        }
        "/usuario/$controller" (controller: "UsuarioController"){
            action = [GET: 'show', POST: 'create']
        }
        "/usuario/$controller/$action" (controller: "UsuarioController"){
            action = [GET: 'edad']
        }
        "500"(view:'/error')
	}
}
