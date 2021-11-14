package com.yesferal.hornsapp.core.domain.navigator

interface Navigator<V> {
    fun navigate(view: V, direction: Direction)
}
