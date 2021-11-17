package com.yesferal.hornsapp.core.data.repository

import com.yesferal.hornsapp.core.data.abstraction.remote.DrawerRemoteDataSource
import com.yesferal.hornsapp.core.domain.abstraction.DrawerRepository
import com.yesferal.hornsapp.core.domain.entity.drawer.CategoryDrawer
import com.yesferal.hornsapp.core.domain.entity.drawer.ScreenDrawer
import kotlinx.coroutines.flow.Flow

class DrawerRepositoryImpl(private val drawerRemoteDataSource: DrawerRemoteDataSource): DrawerRepository {

    override fun getHomeDrawer(): Flow<List<ScreenDrawer>> {
        return drawerRemoteDataSource.homeDrawer
    }

    override fun getNewestDrawer(): Flow<List<ScreenDrawer>> {
        return drawerRemoteDataSource.newestDrawer
    }

    override fun getCategoryDrawer(): Flow<List<CategoryDrawer>> {
        return drawerRemoteDataSource.categoryDrawer
    }
}
