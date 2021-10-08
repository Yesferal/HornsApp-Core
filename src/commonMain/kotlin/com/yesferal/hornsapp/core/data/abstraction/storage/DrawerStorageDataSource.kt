package com.yesferal.hornsapp.core.data.abstraction.storage

import com.yesferal.hornsapp.core.domain.entity.drawer.AppDrawer

interface DrawerStorageDataSource {
    fun getAppDrawer(): AppDrawer
    fun updateAppDrawer(appDrawer: AppDrawer)
}
