

package com.example.examenfinal.model

import java.io.Serializable

data class Launch(
    val id: String? = null,
    val name: String? = null,
    val details: String? = null,
    val links: Links? = null
) : Serializable

data class Links(
    val patch: Patch? = null
) : Serializable

data class Patch(
    val small: String? = null
) : Serializable
