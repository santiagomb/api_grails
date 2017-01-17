import apirest.Article

import apirest.Usuario

class BootStrap {

    def init = { servletContext ->

        def admin = new Usuario(dni: "99999999", nombre: "Admin", email: "admin@admin.com", nacimiento: "03/05/1992")
        def lista = new ArrayList<String>()
        def lista2 = new ArrayList<String>()

        admin.save()
        lista.add("algo")

        def lista3 = Arrays.asList("algo","asd")
        new Article(title: "Título del artículo", contenido: "Esto es el contenido del artículo",
                autor: admin, visitas: 0, comentarios: lista3).save()
        new Article(title:"Otro título", contenido: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",
                autor: admin, visitas: 0, comentarios: lista2).save()
    }
    def destroy = {
    }
}
