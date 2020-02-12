package testgrails

class SecurityFilters {

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                if (!session.user && actionName != "login") {
                    redirect(controller: "authentication", action: "login")
                    return false
                }
            }
        }
    }
}
