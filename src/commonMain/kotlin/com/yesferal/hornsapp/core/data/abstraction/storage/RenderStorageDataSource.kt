package com.yesferal.hornsapp.core.data.abstraction.storage

import com.yesferal.hornsapp.core.domain.entity.render.AppRender

interface RenderStorageDataSource {
    fun getAppRender(): AppRender?
    fun updateAppRender(appRender: AppRender)
}
