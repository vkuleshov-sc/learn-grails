package commands

@grails.validation.Validateable
class UserCommand {
    def dateFromFilter
    def dateToFilter

    static constraints = {
        dateFromFilter validator: { val, obj, errors ->
            if (val instanceof Date && val > new Date()) {
                errors.rejectValue('dateFromFilter', 'fromFuture')
            }
        }
        dateToFilter validator: { val, obj, errors ->
            if (val instanceof Date && val > new Date()) {
                errors.rejectValue('dateToFilter', 'fromFuture')
            }
            if (val instanceof Date && obj.dateFromFilter instanceof Date && val < obj.dateFromFilter) {
                errors.rejectValue('dateToFilter', 'less')
            }
        }
    }
}
