package business

import repository.ContactRepository
import repository.entity.ContactEntity
import java.lang.Exception

class ContactBusiness {



    private fun validate(name: String, phone: String) {
        if (name.isEmpty() || phone.isEmpty()) throw Exception("Nome e telefone é obrigatório")
    }

    private fun validateDelete(name: String,phone: String){
        if (name.isEmpty() || phone.isEmpty()){
            throw Exception("É necessario selecionar um contato antes de remover.")
        }
    }
    fun contactDescription(): String{
        val list = getList()
        return when{
            list.isEmpty() -> "0 Contatos"
            list.size == 1 -> "1 contato"
            else -> "${list.size} contatos"
        }
    }
    fun save(name: String, phone: String) {
        val contact = ContactEntity(name, phone)
        validate(name, phone)
        ContactRepository.save(contact)
    }

    fun delete(name:String, phone: String){
        val contact = ContactEntity(name, phone)
        validateDelete(name, phone)
        ContactRepository.delete(contact)
    }

    fun getList(): List<ContactEntity>{
        return ContactRepository.getList()
    }
}
