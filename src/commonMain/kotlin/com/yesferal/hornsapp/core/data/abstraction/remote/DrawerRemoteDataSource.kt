/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.data.abstraction.remote

import com.yesferal.hornsapp.core.domain.entity.drawer.ViewDrawer
import kotlinx.coroutines.flow.Flow

interface DrawerRemoteDataSource {
    val homeDrawer: Flow<List<ViewDrawer>>
    val newestDrawer: Flow<List<ViewDrawer>>
    val categoryDrawer: Flow<List<ViewDrawer>>
}
