package repository

import repository.entity.ContactEntity

class ContactRepository {
    companion object{

        private val contactList = mutableListOf<ContactEntity>()
        fun save(contactEntity: ContactEntity) {
            contactList.add(contactEntity)
        }

        var index = 0
        fun delete(contactEntity: ContactEntity){
            for (item in contactList.withIndex()){
                if (item.value.name == contactEntity.name &&
                    item.value.phone == contactEntity.phone){
                        index = item.index
                    break
                }
            }
            contactList.removeAt(index)
        }
        fun getList(): List<ContactEntity>{
            return contactList
        }
    }

}