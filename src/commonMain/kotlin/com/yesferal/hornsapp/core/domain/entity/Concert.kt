package com.yesferal.hornsapp.core.domain.entity

data class Concert private constructor(
    val id: String,
    val name: String?,
    val headlinerImage: String?,
    val timeInMillis: Long?,
    val totalDays: Int?,
    val genre: String?,
    val tags: List<String>?,
    var isFavorite: Boolean,
    val description: String?,
    val trailerUrl: String?,
    val facebookUrl: String?,
    val venue: Venue?,
    val bands: List<Band>?,
    val ticketingUrl: String?,
    val ticketingHost: String?
) {
    class Builder(val id: String) {
        private var name: String? = null
        private var headlinerImage: String? = null
        private var timeInMillis: Long? = null
        private var genre: String? = null
        private var tags: List<String>? = null
        private var isFavorite: Boolean = false
        private var description: String? = null
        private var trailerUrl: String? = null
        private var facebookUrl: String? = null
        private var venue: Venue? = null
        private var bands: List<Band>? = null
        private var ticketingUrl: String? = null
        private var ticketingHost: String? = null
        private var totalDays: Int? = null

        fun addName(name: String?) = apply {
            this.name = name
        }

        fun addHeadlinerImage(headlinerImage: String?) = apply {
            this.headlinerImage = headlinerImage
        }

        fun addTimeInMillis(timeInMillis: Long?) = apply {
            this.timeInMillis = timeInMillis
        }

        fun addGenre(genre: String?) = apply {
            this.genre = genre
        }

        fun addTags(tags: List<String>?) = apply {
            this.tags = tags
        }

        fun isFavorite(isFavorite: Boolean) = apply {
            this.isFavorite = isFavorite
        }

        fun addDescription(description: String?) = apply {
            this.description = description
        }

        fun addTrailerUrl(trailerUrl: String?) = apply {
            this.trailerUrl = trailerUrl
        }

        fun addFacebookUrl(facebookUrl: String?) = apply {
            this.facebookUrl = facebookUrl
        }

        fun addVenue(venue: Venue?) = apply {
            this.venue = venue
        }

        fun addBands(bands: List<Band>?) = apply {
            this.bands = bands
        }

        fun addTicketingUrl(ticketingUrl: String?) = apply {
            this.ticketingUrl = ticketingUrl
        }

        fun addTicketingHost(ticketingHost: String?) = apply {
            this.ticketingHost = ticketingHost
        }

        fun addTotalDays(totalDays: Int?) = apply {
            this.totalDays = totalDays
        }

        fun build(): Concert {
            return Concert(
                id,
                name,
                headlinerImage,
                timeInMillis,
                totalDays,
                genre,
                tags,
                isFavorite,
                description,
                trailerUrl,
                facebookUrl,
                venue,
                bands,
                ticketingUrl,
                ticketingHost
            )
        }
    }
}
