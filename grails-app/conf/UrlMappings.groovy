class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }
        "/"(view: '/index')
        "500"(view: '/error')
        "/task3"(view: "/task3", controller: "task3")
    }
}