package com.udfsoft.androidinfo.lib.command.cpu

import com.udfsoft.androidinfo.lib.command.CommandInterface
import com.udfsoft.androidinfo.lib.command.entity.LocalCPUCore
import com.udfsoft.androidinfo.lib.entity.CPUInformation
import com.udfsoft.androidinfo.lib.mapper.LocalCoreToCoreMapper
import com.udfsoft.androidinfo.lib.util.NumberUtils.toSafeInt

class GetCpuInformationCommand : CommandInterface<Unit, CPUInformation> {

    private var core: LocalCPUCore? = null

    override fun invoke(param: Unit): CPUInformation {
        val processBuilder = ProcessBuilder(DATA)
        val process = processBuilder.start()
        val localCores = mutableListOf<LocalCPUCore>()
        var type = ""
        process.inputStream.use {
            it.bufferedReader().use { bufferReader ->
                var text: String?
                while ((bufferReader.readLine().also { line -> text = line }) != null) {
                    val trimText = text?.trim() ?: ""
                    when {
                        trimText.startsWith("Processor") -> {
                            parseValue(trimText) { value ->
                                type = value
                            }
                        }
                        trimText.startsWith("processor") -> {
                            parseValue(trimText) { value ->
                                core = LocalCPUCore(value.toSafeInt())
                                localCores.add(core!!)
                            }
                        }
                        trimText.startsWith("BogoMIPS") -> {
                            parseValue(trimText) { value ->
                                core?.bogoMIPS = value.toDoubleOrNull() ?: 0.0
                            }
                        }
                        trimText.startsWith("Features") -> {
                            parseValue(trimText) { value ->
                                core?.features = value
                            }
                        }
                        trimText.startsWith("CPU implementer") -> {
                            parseValue(trimText) { value ->
                                core?.implementer = value.toSafeInt()
                            }
                        }
                        trimText.startsWith("CPU architecture") -> {
                            parseValue(trimText) { value ->
                                core?.architecture = value.toSafeInt()
                            }
                        }
                        trimText.startsWith("CPU variant") -> {
                            parseValue(trimText) { value ->
                                core?.variant = value.toSafeInt()
                            }
                        }
                        trimText.startsWith("CPU part") -> {
                            parseValue(trimText) { value ->
                                core?.part = value.toSafeInt()
                            }
                        }
                        trimText.startsWith("CPU revision") -> {
                            parseValue(trimText) { value ->
                                core?.revision = value.toSafeInt()
                            }
                        }
                    }
                }
            }
        }

        return CPUInformation(type, localCores.map(LocalCoreToCoreMapper()::invoke))
    }

    private fun parseValue(text: String, callback: (String) -> Unit) {
        val keyValue = text.split(":")
        val value = keyValue[1].trim()
        callback(value)
    }

    companion object {
        private val DATA = listOf("/system/bin/cat", "/proc/cpuinfo")

    }
}