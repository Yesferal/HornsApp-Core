package com.yesferal.hornsapp.core.data.abstraction.storage

import com.yesferal.hornsapp.core.domain.entity.render.AppRenderContract

interface RenderStorageDataSource {
    fun getAppRender(): AppRenderContract?
    fun updateAppRender(appRender: AppRenderContract)
}
