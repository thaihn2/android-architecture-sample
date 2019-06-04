package thaihn.com.androidcleanarchitecture.model

import thaihn.com.domain.model.Model

interface ItemMapper<M : Model, MI : ModelItem> {
  fun mapToPresentation(model: M): MI

  fun mapToDomain(modelItem: MI): M
}