package com.yesferal.hornsapp.core.domain.navigator

class Direction private constructor(
    val to: ScreenType,
    val parameter: NavViewData?
) {

    class Build {
        private var to: ScreenType = ScreenType.NONE
        private var parameter: NavViewData? = null

        fun to(to: ScreenType): Build {
            this.to = to

            return this
        }

        fun to(to: String): Build {
            try {
                this.to = ScreenType.valueOf(to)
            } catch (e: Exception) {
                this.to = ScreenType.NONE
            }

            return this
        }

        fun with(parameter: NavViewData?): Build {
            this.parameter = parameter

            return this
        }

        fun build(): Direction {
            return Direction(to, parameter)
        }
    }
}
