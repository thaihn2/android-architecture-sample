package thaihn.com.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import thaihn.com.domain.model.User
import javax.inject.Inject

@Entity(tableName = "users")
class UserEntity(
    @PrimaryKey @ColumnInfo(name = "id") @field: SerializedName("id") val id: Int,
    @ColumnInfo(name = "name") @field: SerializedName("login") val name: String,
    @ColumnInfo(name = "avatar") @field: SerializedName("avatar_url") val avatar: String,
    @ColumnInfo(name = "type") @field: SerializedName("type") val type: String
) : ModelEntity()


class MapperUserEntity @Inject constructor() : MapperEntity<User, UserEntity> {
  override fun mapToModel(entity: UserEntity): User = User(
      id = entity.id,
      name = entity.name,
      avatar = entity.avatar,
      type = entity.type
  )

  override fun mapToEntity(model: User): UserEntity = UserEntity(
      id = model.id,
      name = model.name,
      avatar = model.avatar,
      type = model.type
  )
}
