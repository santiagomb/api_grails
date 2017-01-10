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
            action = [DELETE: 'delete', PUT: 'update']
        }
        "500"(view:'/error')
	}
}
