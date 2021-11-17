package com.yesferal.hornsapp.core.domain.abstraction

import com.yesferal.hornsapp.core.domain.entity.drawer.CategoryDrawer
import com.yesferal.hornsapp.core.domain.entity.drawer.ScreenDrawer
import kotlinx.coroutines.flow.Flow

interface DrawerRepository {
    fun getHomeDrawer(): Flow<List<ScreenDrawer>>
    fun getNewestDrawer(): Flow<List<ScreenDrawer>>
    fun getCategoryDrawer(): Flow<List<CategoryDrawer>>
}
