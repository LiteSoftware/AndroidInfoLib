package com.udfsoft.androidinfo.lib.command

interface CommandInterface<P, R> {

    operator fun invoke(param: P): R
}