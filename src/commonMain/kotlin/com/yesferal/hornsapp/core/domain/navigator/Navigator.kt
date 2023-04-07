package com.yesferal.hornsapp.core.domain.navigator

class Navigator private constructor(
    val to: ScreenType,
    val popBackStackId: Int?,
    val parameter: NavViewData?,
) {
    class Builder {
        private var to: ScreenType = ScreenType.NONE
        private var popBackStackId: Int? = null
        private var parameter: NavViewData? = null

        fun to(to: ScreenType): Builder {
            this.to = to

            return this
        }

        fun to(to: String): Builder {
            try {
                this.to = ScreenType.valueOf(to)
            } catch (e: Exception) {
                this.to = ScreenType.NONE
            }

            return this
        }

        fun popBackStack(popBackStackId: Int): Builder {
            this.popBackStackId = popBackStackId

            return this
        }

        fun with(parameter: NavViewData?): Builder {
            this.parameter = parameter

            return this
        }

        fun build(): Navigator {
            return Navigator(to, popBackStackId, parameter)
        }
    }
}
