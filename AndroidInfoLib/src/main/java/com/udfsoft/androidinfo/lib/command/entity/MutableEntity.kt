package com.udfsoft.androidinfo.lib.command.entity

interface MutableEntity<P> {
    fun build(): P
}