package com.yesferal.hornsapp.core.domain.navigator

class Direction private constructor(
    val to: ScreenType,
    val parameter: NavViewData?
) {

    class Build {
        private var to: ScreenType = ScreenType.None
        private var parameter: NavViewData? = null

        fun to(to: ScreenType): Build {
            this.to = to
            return this
        }

        fun with(parameter: NavViewData): Build {
            this.parameter = parameter
            return this
        }

        fun build(): Direction {
            return Direction(to, parameter)
        }
    }
}
