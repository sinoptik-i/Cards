package com.sinoptik_.cards.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Bank (

  @SerialName("name" ) var name : String? = null,
  @SerialName("url" ) var url : String? = null,
  @SerialName("phone" ) var phone : String? = null,
  @SerialName("city" ) var city : String? = null,



)