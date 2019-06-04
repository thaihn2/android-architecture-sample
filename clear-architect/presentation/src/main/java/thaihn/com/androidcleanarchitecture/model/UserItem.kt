package thaihn.com.androidcleanarchitecture.model

import thaihn.com.domain.model.User
import javax.inject.Inject

class UserItem(
    val id: Int,
    val name: String,
    val avatar: String,
    val type: String
) : ModelItem()

class UserItemMapper @Inject constructor() : ItemMapper<User, UserItem> {
  override fun mapToPresentation(model: User) = UserItem(
      id = model.id,
      name = model.name,
      avatar = model.avatar,
      type = model.type
  )

  override fun mapToDomain(modelItem: UserItem) = User(
      id = modelItem.id,
      name = modelItem.name,
      avatar = modelItem.avatar,
      type = modelItem.type
  )
}



