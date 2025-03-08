/* Copyright © 2021 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.entity.Concert
import com.yesferal.hornsapp.core.domain.entity.render.CategoryRender

/**
 * This Use Case Provide concerts filtered
 * depending on a [CategoryRender.key]
 *
 * @author Yesferal
 */
class FilterConcertsByCategoryUseCase {
    operator fun invoke(concerts: List<Concert>, categoryKey: String?): List<Concert> {
        return categoryKey?.let {
            concerts.filter {
                categoryKey == CategoryRender.ALL || it.tags?.contains(categoryKey) == true
            }
        }?: kotlin.run { emptyList() }
    }
}
