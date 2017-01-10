import apirest.Article

class BootStrap {

    def init = { servletContext ->
        new Article(title: "Título del artículo", contenido: "Esto es el contenido del artículo",
                autor: "Admin", visitas: 0, comentarios: ["Buena noticia", "Horrible"]).save()
        new Article(title:"Otro título", contenido: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",
                autor: "Admin", visitas: 0, comentarios: ["No tan bueno", "Me parecio genial"]).save()
    }
    def destroy = {
    }
}
