package testgrails

class SecurityFilters {

    def filters = {
        all(controller: 'user', action: '*') {
            before = {
                if (!session.user && actionName != "login") {
                    redirect(controller: "user", action: "login")
                    return false
                }
            }
        }
    }
}
