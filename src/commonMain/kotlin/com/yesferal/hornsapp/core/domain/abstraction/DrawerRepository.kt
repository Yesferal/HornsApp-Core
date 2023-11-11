/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.domain.abstraction

import com.yesferal.hornsapp.core.domain.entity.drawer.ViewDrawer
import kotlinx.coroutines.flow.Flow

interface DrawerRepository {
    fun getHomeDrawer(): Flow<List<ViewDrawer>>
    fun getNewestDrawer(): Flow<List<ViewDrawer>>
    fun getCategoryDrawer(): Flow<List<ViewDrawer>>
}
