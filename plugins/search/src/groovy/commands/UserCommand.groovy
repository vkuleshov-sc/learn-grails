package commands

import grails.validation.Validateable
import org.grails.databinding.BindUsing
import org.grails.databinding.BindingFormat
import utils.DataFormatter

@Validateable
class UserCommand {
    @BindingFormat('yyyy-MM-dd')
    Date dateFromFilter
    @BindingFormat('yyyy-MM-dd')
    Date dateToFilter
    @BindUsing({ obj, source ->
        return DataFormatter.getFormatName(source['userNameFilter'])
    })
    String userNameFilter
    @BindUsing({ obj, source ->
        return DataFormatter.getFormatName(source['pokemonNameFilter'])
    })
    String pokemonNameFilter
    @BindUsing({ obj, source ->
        return source['page'] ?: 1
    })
    Integer page

    static constraints = {
        dateFromFilter bindable: true, nullable: true, validator: { val, obj, errors ->
            if (val && val > new Date()) {
                errors.rejectValue('dateFromFilter', 'fromFuture')
            }
        }
        dateToFilter bindable: true, nullable: true, validator: { val, obj, errors ->
            if (val && val > new Date()) {
                errors.rejectValue('dateToFilter', 'fromFuture')
            }
            if (val && obj.dateFromFilter && val < obj.dateFromFilter) {
                errors.rejectValue('dateToFilter', 'less')
            }
        }
        userNameFilter bindable: true, nullable: true
        pokemonNameFilter bindable: true, nullable: true
    }
}
