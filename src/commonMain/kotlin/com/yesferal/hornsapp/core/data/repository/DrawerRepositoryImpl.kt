/* Copyright © 2023 HornsApp. All rights reserved. */
package com.yesferal.hornsapp.core.data.repository

import com.yesferal.hornsapp.core.data.abstraction.remote.DrawerRemoteDataSource
import com.yesferal.hornsapp.core.domain.abstraction.DrawerRepository
import com.yesferal.hornsapp.core.domain.entity.drawer.ViewDrawer
import kotlinx.coroutines.flow.Flow

class DrawerRepositoryImpl(private val drawerRemoteDataSource: DrawerRemoteDataSource): DrawerRepository {

    override fun getHomeDrawer(): Flow<List<ViewDrawer>> {
        return drawerRemoteDataSource.homeDrawer
    }

    override fun getNewestDrawer(): Flow<List<ViewDrawer>> {
        return drawerRemoteDataSource.newestDrawer
    }

    override fun getCategoryDrawer(): Flow<List<ViewDrawer>> {
        return drawerRemoteDataSource.categoryDrawer
    }
}
