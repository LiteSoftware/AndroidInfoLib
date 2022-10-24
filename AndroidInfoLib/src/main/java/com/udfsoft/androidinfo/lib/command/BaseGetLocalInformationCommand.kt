package com.udfsoft.androidinfo.lib.command

import com.udfsoft.androidinfo.lib.command.entity.MutableEntity

abstract class BaseGetLocalInformationCommand<P : MutableEntity<*>> : CommandInterface<P,Unit>