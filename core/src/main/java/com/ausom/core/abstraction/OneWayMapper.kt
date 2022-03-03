package com.ausom.core.abstraction


/**
 *
 * This is an abstraction for mapper class
 * Allows one way transformation of one type to another
 *
 */
interface OneWayMapper<in Before, out After> {
    fun map(before: Before) : After
    fun mapList(before: List<Before>) : List<After> = before.mapTo(mutableListOf(), ::map)
}