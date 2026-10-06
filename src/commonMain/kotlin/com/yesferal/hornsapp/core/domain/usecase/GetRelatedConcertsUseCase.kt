/* Copyright © 2026 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.usecase

import com.yesferal.hornsapp.core.domain.entity.Concert

/**
 * Returns concerts that share at least one category with [current],
 * excluding [current] itself. Sorted by date ascending and capped by [take].
 *
 * Used for "Related events" on concert detail.
 *
 * @author Yesferal
 */
class GetRelatedConcertsUseCase {
    operator fun invoke(
        concerts: List<Concert>,
        current: Concert,
        take: Int = DEFAULT_TAKE,
    ): List<Concert> {
        val categories = current.categories
        if (categories.isNullOrEmpty() || take <= 0) {
            return emptyList()
        }

        return concerts
            .asSequence()
            .filter { it.id != current.id }
            .filter { other ->
                other.categories?.any { category -> categories.contains(category) } == true
            }
            .sortedBy { it.timeInMillis }
            .take(take)
            .toList()
    }

    companion object {
        const val DEFAULT_TAKE = 4
    }
}
