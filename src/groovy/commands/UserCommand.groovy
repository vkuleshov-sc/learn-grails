package commands

import grails.validation.Validateable
import org.grails.databinding.BindUsing
import org.grails.databinding.BindingFormat

@Validateable
class UserCommand {
    @BindingFormat('yyyy-MM-dd')
    Date dateFromFilter
    @BindingFormat('yyyy-MM-dd')
    Date dateToFilter
    @BindUsing({ obj, source ->
        return obj.getFormatName(source['userNameFilter'])
    })
    String userNameFilter
    @BindUsing({ obj, source ->
        return obj.getFormatName(source['pokemonNameFilter'])
    })
    String pokemonNameFilter
    @BindUsing({ obj, source ->
        return source['page'] ?: 1
    })
    Integer page

    static String getFormatName(String name){
        return name.replaceAll(/\*/, "%").trim()
    }

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
