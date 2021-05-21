package repository

import repository.entity.ContactEntity

class ContactRepository {
    companion object{

        private val contactList = mutableListOf<ContactEntity>()
        fun save(contactEntity: ContactEntity) {
            contactList.add(contactEntity)
        }

        fun delete(contactEntity: ContactEntity){
        }
        fun getList(): List<ContactEntity>{
            return contactList
        }
    }

}