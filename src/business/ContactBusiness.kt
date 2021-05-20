package business

import repository.ContactRepository
import repository.entity.ContactEntity
import java.lang.Exception

class ContactBusiness {

    fun validate(name: String, phone: String) {
        if (name.isEmpty() && phone.isEmpty()) throw Exception("Nome e telefone é obrigatório")
    }

    fun validateDelete(name: String,phone: String){
        if (name.isEmpty() || phone.isEmpty()){
            throw Exception("É necessario selecionar um contato antes de remover.")
        }
    }

    fun save(name: String, phone: String) {
        validate(name, phone)
        val contact = ContactEntity(name, phone)
        ContactRepository().save(contact)
    }

    fun delete(name:String, phone: String){
        validateDelete(name, phone)
    }
}
