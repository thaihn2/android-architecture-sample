package thaihn.com.data.entity

import thaihn.com.domain.model.Model

interface MapperEntity<M : Model, ME : ModelEntity> {
  fun mapToModel(entity: ME): M

  fun mapToEntity(model: M): ME
}