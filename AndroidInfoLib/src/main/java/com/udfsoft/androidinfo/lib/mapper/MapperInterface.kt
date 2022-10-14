package com.udfsoft.androidinfo.lib.mapper

interface MapperInterface<P, R> {

    operator fun invoke(param: P): R
}