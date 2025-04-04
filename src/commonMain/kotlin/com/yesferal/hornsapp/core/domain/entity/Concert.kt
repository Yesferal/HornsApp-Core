package com.yesferal.hornsapp.core.domain.entity

import com.yesferal.hornsapp.core.domain.entity.render.ViewRender

data class Concert constructor(
    val id: String,
    val name: String?,
    val about: String?,
    val timeInMillis: Long?,
    val totalDays: Int?,
    val headlinerName: String?,
    val headlinerImageUrl: String?,
    val ticketingName: String?,
    val ticketingUrl: String?,
    val links: List<ViewRender>?,
    val tags: List<String>?,
    val venue: Venue?,
    val state: State?,
    val bands: List<Band>?,
    val lineup: List<Lineup>?,
    var isFavorite: Boolean,
) {
    class Builder(val id: String) {
        private var name: String? = null
        private var about: String? = null
        private var timeInMillis: Long? = null
        private var totalDays: Int? = null
        private var headlinerName: String? = null
        private var headlinerImageUrl: String? = null
        private var ticketingName: String? = null
        private var ticketingUrl: String? = null
        private var links: List<ViewRender>? = null
        private var tags: List<String>? = null
        private var venue: Venue? = null
        private var state: State? = null
        private var bands: List<Band>? = null
        private var isFavorite: Boolean = false
        private  var lineup: List<Lineup>? = null

        fun addName(name: String?) = apply {
            this.name = name
        }

        fun addAbout(about: String?) = apply {
            this.about = about
        }

        fun addTimeInMillis(timeInMillis: Long?) = apply {
            this.timeInMillis = timeInMillis
        }

        fun addTotalDays(totalDays: Int?) = apply {
            this.totalDays = totalDays
        }

        fun addHeadlinerName(headlinerName: String?) = apply {
            this.headlinerName = headlinerName
        }

        fun addHeadlinerImageUrl(headlinerImageUrl: String?) = apply {
            this.headlinerImageUrl = headlinerImageUrl
        }

        fun addTicketingName(ticketingName: String?) = apply {
            this.ticketingName = ticketingName
        }

        fun addTicketingUrl(ticketingUrl: String?) = apply {
            this.ticketingUrl = ticketingUrl
        }

        fun addLinks(links: List<ViewRender>?) = apply {
            this.links = links
        }

        fun addTags(tags: List<String>?) = apply {
            this.tags = tags
        }

        fun addVenue(venue: Venue?) = apply {
            this.venue = venue
        }

        fun addState(state: State?) = apply {
            this.state = state
        }

        fun addBands(bands: List<Band>?) = apply {
            this.bands = bands
        }

        fun isFavorite(isFavorite: Boolean) = apply {
            this.isFavorite = isFavorite
        }

        fun addLineup(lineup: List<Lineup>?) = apply {
            this.lineup = lineup
        }

        fun build(): Concert {
            return Concert(
                id,
                name,
                about,
                timeInMillis,
                totalDays,
                headlinerName,
                headlinerImageUrl,
                ticketingName,
                ticketingUrl,
                links,
                tags,
                venue,
                state,
                bands,
                lineup,
                isFavorite
            )
        }
    }
}
