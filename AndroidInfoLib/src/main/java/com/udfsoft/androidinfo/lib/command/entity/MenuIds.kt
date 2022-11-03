package com.udfsoft.androidinfo.lib.command.entity

enum class MenuIds(val menuId: Int) {

    MENU_ID_GENERAL(1000),
    MENU_ID_DESIGN(2000),
    MENU_ID_SIM(3000),
    MENU_ID_MOBILE_NETWORK(4000),
    MENU_ID_OS(6000),
    MENU_ID_PROCESSOR(28000),
    MENU_ID_GPU(29000),
    MENU_ID_MEMORY(30000),
    MENU_ID_STORAGE(8000),
    MENU_ID_DISPLAY(10000),
    MENU_ID_SENSORS(11000),
    MENU_ID_REAR_CAMERA(12000),
    MENU_ID_FRONT_CAMERA(13000),
    MENU_ID_AUDIO(14000),
    MENU_ID_WIRELESS(17000),
    MENU_ID_USB(19000),
    MENU_ID_BROWSER(22000),
    MENU_ID_CODECS(23000),
    MENU_ID_BATTERY(25000),
    MENU_ID_SAR(26000);

    companion object {
        fun findMenuIdByIndex(index: Int) = values().firstOrNull { it.ordinal == index }
    }
}