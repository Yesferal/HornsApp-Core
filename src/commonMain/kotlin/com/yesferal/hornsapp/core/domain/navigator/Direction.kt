package com.yesferal.hornsapp.core.domain.navigator

class Direction private constructor(
    val to: ScreenType,
    val popBackStackId: Int?,
    val parameter: NavViewData?
) {

    class Build {
        private var to: ScreenType = ScreenType.NONE
        private var popBackStackId: Int? = null
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

        fun popBackStack(popBackStackId: Int): Build {
            this.popBackStackId = popBackStackId

            return this
        }

        fun with(parameter: NavViewData?): Build {
            this.parameter = parameter

            return this
        }

        fun build(): Direction {
            return Direction(to, popBackStackId, parameter)
        }
    }
}
