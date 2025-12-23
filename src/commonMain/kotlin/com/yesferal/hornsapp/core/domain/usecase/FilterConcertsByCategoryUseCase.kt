/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.entity.render.CategoryRenderContract

/**
 * This Use Case Provide concerts filtered
 * depending on a [CategoryRender]
 *
 * @author Yesferal
 */
class FilterConcertsByCategoryUseCase {
    operator fun invoke(concerts: List<Concert>, categoryId: String?): List<Concert> {
        return categoryId?.let {
            concerts.filter {
                categoryId == CategoryRenderContract.ALL || it.categories?.contains(categoryId) == true
            }
        }?: kotlin.run { emptyList() }
    }
}
